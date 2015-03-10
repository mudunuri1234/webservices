package com.learning.saaj;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.net.URL;

public class SOAPMessageGenerator {

    public static void main(String args[]) {
        try {
            SOAPMessageGenerator generator = new SOAPMessageGenerator();

            //generator.createSOAPPartUsingDOM();

            //generator.createSOAPBodyUsingDOM();

            generator.callWebService();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void createSOAPPartUsingDOM() throws Exception {
        //Creating a DOM document using request XML.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document w3cDocument = builder.parse("C:/projects/Learning/SpringWS/src/com/learning/saaj/employee.xml");
        DOMSource domSource = new DOMSource(w3cDocument);

        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = messageFactory.createMessage();
        SOAPPart soapPart = message.getSOAPPart();

        //Adding DOM source to soap part object.
        soapPart.setContent(domSource);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);
    }

    private void createSOAPBodyUsingDOM() throws Exception {
        //Creating a DOM document using request XML.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document w3cDocument = builder.parse("C:/projects/Learning/SpringWS/src/com/learning/saaj/employeebody.xml");

        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory messageFactory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = messageFactory.createMessage();

        //Adding DOM source to the soap body.
        SOAPBody soapBody = message.getSOAPBody();
        soapBody.addDocument(w3cDocument);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);
    }

    private void callWebService() throws Exception {
        SOAPConnectionFactory  soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        //Web service endpoint URL
        URL endpoint = new URL("http://localhost:8080/wsbook/services/employee");

        //Creating a w3c DOM document.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document w3cDocument = builder.parse("C:/projects/Learning/SpringWS/src/com/learning/saaj/inputdata.xml");

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
