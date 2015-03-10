package com.learning.ws.jaxws.composite;

import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Document;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.soap.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.net.URL;
import java.io.ByteArrayOutputStream;

public class CompositeClient {

    public static void main(String args[]) throws Exception {
        try {
            CompositeClient client = new CompositeClient();
            //client.invokeSOAPEndpoint();
            client.invokeRestEndpoint();

            client.callWebService();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeSOAPEndpoint() throws Exception {
        URL url = new URL("http://localhost:8080/wsbook/services/jaxwsGradeService?wsdl");
        QName qname = new QName("http://composite.jaxws.ws.learning.com/", "GradeManagerImplService");
        Service service = Service.create(url, qname);
        GradeManager gradeManager = service.getPort(GradeManager.class);

        String subjects = gradeManager.getGradeSubjects(1);
        System.out.println("---- subjects is ---- " + subjects);

    }

    private void invokeRestEndpoint() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/wsbook/services/compositegradeservice/grade/{grade}", String.class, "1");
        System.out.println("---- result is ---- " + result);
    }

     private void callWebService() throws Exception {
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        //Web service endpoint URL
        URL endpoint = new URL("http://localhost:8080/wsbook/services/jaxwsGradeService");

        //Creating a w3c DOM document.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document w3cDocument = builder.parse("C:/projects/Learning/SpringWS/src/com/learning/saaj/inputdata1.xml");

        //Creating the request SOAP Message using SAAJ API.
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = messageFactory.createMessage();
        SOAPBody soapBody = message.getSOAPBody();
        soapBody.addDocument(w3cDocument);

        //Calling the service endpoint to get the response.
        SOAPMessage response = soapConnection.call(message, endpoint);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        response.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);

        //Closing the connection
        soapConnection.close();
    }

}
