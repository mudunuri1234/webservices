package com.learning.ws.jaxws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.ws.Service;
import javax.xml.ws.Dispatch;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.soap.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class JAXWSClient {

    public static void main(String args[]) throws Exception {
        try {
            JAXWSClient client = new JAXWSClient();
            //client.getJaxWSOutputForJava2WSDL();

            client.testJAXWSClient();
            //client.testCreateDispatch();

            //client.testCreateDispatchUsingDOM();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getJaxWSOutputForJava2WSDL() throws Exception {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.getInInterceptors().add(new LoggingInInterceptor());
        factory.getOutInterceptors().add(new LoggingOutInterceptor());
        factory.setServiceClass(EmployeeService.class);
        factory.setAddress("http://localhost:8080/wsbook/services/employee");
        EmployeeService client = (EmployeeService) factory.create();

        Employee employee = client.getEmployee("823147");
        System.out.println("Server said: " + employee.getEmployeeId() +
                ", " + employee.getLastName() +
                ", " + employee.getFirstName());

        //String data = client.getEmployeeAddressInfo("823147");
        //System.out.println("Server said: " + data);

        //client.deleteEmployee("823147");
    }

    private void testJAXWSClient() throws Exception {
        URL url = new URL("http://localhost:8080/wsbook/services/employee?wsdl");
        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeService");
        Service service = Service.create(url, qname);
        EmployeeService employeeService = service.getPort(EmployeeService.class);

        Client client = ClientProxy.getClient(employeeService);
        client.getInInterceptors().add(new LoggingInInterceptor());
        client.getOutInterceptors().add(new LoggingOutInterceptor());

        String address = employeeService.getEmployeeAddressInfo("823147");
        System.out.println("Address is : " + address);

        Employee emp = employeeService.getEmployee("133334");
        System.out.println("Employee Id:" + emp.getEmployeeId() + 
                "-- First Name --" + emp.getFirstName() + "-- Last Name --" + emp.getLastName());
    }

    private void testCreateDispatch() throws Exception {
        URL url = new URL("http://localhost:8080/wsbook/services/employee?wsdl");
        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeService");
        Service service = Service.create(url, qname);

        QName portName = new QName("http://jaxws.ws.learning.com/", "EmployeeServicePort");

        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
        System.out.println("---------- dispatch -------" + dispatch.toString());

        // Use Dispatch as BindingProvider
        BindingProvider bp = (BindingProvider) dispatch;

        // Optionally Configure RequestContext to send SOAPAction HTTP Header
//        Map<String, Object> rc = bp.getRequestContext();
//        rc.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
//        rc.put(BindingProvider.SOAPACTION_URI_PROPERTY, "hello");

        // Obtain a preconfigured SAAJ MessageFactory
        MessageFactory factory = ((SOAPBinding) bp.getBinding()).getMessageFactory();

        // Create SOAPMessage Request
        SOAPMessage request = factory.createMessage();

        // Request Header
        SOAPHeader header = request.getSOAPHeader();

        // Request Body
        SOAPBody body = request.getSOAPBody();

        // Compose the soap:Body payload
        QName payloadName = new QName("http://localhost:8080/wsbook/services/employee", "getEmployee", "ns1");

        SOAPBodyElement payload = body.addBodyElement(payloadName);
        SOAPElement message = payload.addChildElement("employeeId");
        message.addTextNode("12345678");

        // Invoke the endpoint synchronously, Invoke Endpoint Operation and read response
        SOAPMessage reply = dispatch.invoke(request);

        // process the reply
        SOAPBody responseBody = reply.getSOAPBody();
        QName responseName = new QName("http://jaxws.ws.learning.com/", "getEmployeeResponse");
        Iterator iterator = responseBody.getChildElements(responseName);
        SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
        System.out.println("---------- bodyElement -------" + bodyElement.getNodeName());

        for(Element result : getElements(bodyElement.getElementsByTagName("return"))) {
             System.out.println("-- here ---");
             List<Element> resultDataChildren = getElements(result.getChildNodes());
             String employeeId = named(resultDataChildren.get(0), "employeeId").getTextContent();
             String firstName = named(resultDataChildren.get(1), "firstName").getTextContent();
             String lastName = named(resultDataChildren.get(2), "lastName").getTextContent();

             System.out.println(employeeId + firstName + lastName);
        }        

    }

    private static List<Element> getElements(NodeList nodes) {
        List<Element> result = new ArrayList<Element>(nodes.getLength());
        for(int i = 0; i < nodes.getLength(); i++) {
            Node node = (Node) nodes.item(i);
            if(node instanceof Element) {
                result.add((Element)node);
            }
        }
        return result;
    }

    private static Element named(Element element, String name) {
        if(!element.getNodeName().equals(name))
            throw new IllegalArgumentException("Expected " + name + ",but got " + element.getNodeName());
        return element;
    }

     private static void testCreateDispatchUsingDOM() throws Exception {
        URL url = new URL("http://localhost:8080/wsbook/services/employee?wsdl");
        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeService");
        Service service = Service.create(url, qname);

        QName portName = new QName("http://jaxws.ws.learning.com/", "EmployeeServicePort");
        Dispatch<DOMSource> dispatch = service.createDispatch(portName, DOMSource.class, Service.Mode.PAYLOAD);
        
         String inputMsg =
         "   <ns1:getEmployee xmlns:ns1=\"http://jaxws.ws.learning.com/\"> "+
         "     <employeeId>823147</employeeId> " +
         "   </ns1:getEmployee> ";

         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         InputSource is = new InputSource( new StringReader( inputMsg ) );
         Document requestDoc = builder.parse( is );
         DOMSource request = new DOMSource(requestDoc);


        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        Source src = new DOMSource(requestDoc);
        Result dest = new StreamResult(System.out);
        aTransformer.transform(src, dest);
        //System.out.println(" ----------- requestDoc ----------" + request.toString());

        // Dispatch disp created previously
        DOMSource response = dispatch.invoke(request);

     }


}
