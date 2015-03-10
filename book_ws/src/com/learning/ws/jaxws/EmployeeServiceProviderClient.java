package com.learning.ws.jaxws;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.Dispatch;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.soap.SOAPBinding;
import javax.xml.soap.*;
import java.net.URL;
import java.util.*;
import java.io.ByteArrayOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Dec 25, 2011
 * Time: 10:05:00 AM
 */
public class EmployeeServiceProviderClient {

    public static void main(String args[]) throws Exception {
        try {
            EmployeeServiceProviderClient client = new EmployeeServiceProviderClient();
            client.invokeProvider();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeProvider()  throws Exception {
        //serice endpoint URL used to create a service instance
        URL url = new URL("http://localhost:8080/wsbook/services/employeeServiceProvider?wsdl");
        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeServiceProvider");
        Service service = Service.create(url, qname);

        QName portName = new QName("http://jaxws.ws.learning.com/", "EmployeeServiceProviderPort");

        //Create a dispatch instance
        Dispatch<SOAPMessage> dispatch = service.createDispatch(portName, SOAPMessage.class, Service.Mode.MESSAGE);
        System.out.println("---------- dispatch -------" + dispatch.toString());

        //Use Dispatch as BindingProvider
        BindingProvider bp = (BindingProvider) dispatch;

        //create a request message
        MessageFactory factory = ((SOAPBinding) bp.getBinding()).getMessageFactory();
        SOAPMessage request = factory.createMessage();

        // Request message Body
        SOAPBody body = request.getSOAPBody();

        // Compose the soap:Body payload
        QName payloadName = new QName("http://localhost:8080/wsbook/services/employeeServiceProvider", "invoke", "ns1");
        SOAPBodyElement payload = body.addBodyElement(payloadName);
        SOAPElement message = payload.addChildElement("employeeId");
        message.addTextNode("12345678");

        //invoke the service end point.
        SOAPMessage replyMessage = dispatch.invoke(request);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        replyMessage.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  reply Message ------" + responseMessage);

        //process the response to obtain the data.
        SOAPBody responseBody = replyMessage.getSOAPBody();
        for(Element result : getElements(responseBody.getElementsByTagName("getEmployeeResponse"))) {
            List<Element> resultDataChildren = getElements(result.getChildNodes());
            String firstName = getNamedElement(resultDataChildren.get(0), "firstName").getTextContent();
            String lastName = getNamedElement(resultDataChildren.get(1), "lastName").getTextContent();
            System.out.println("-- firstName ---" + firstName + "-- lastName ---" + lastName);
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

    private static Element getNamedElement(Element element, String name) {
        if(!element.getNodeName().equals(name))
            throw new IllegalArgumentException("Expected " + name + ",but got " + element.getNodeName());
        return element;
    }

}
