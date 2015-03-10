package com.learning.saaj;

import javax.xml.soap.*;
import javax.xml.namespace.QName;
import java.io.ByteArrayOutputStream;
import java.util.Locale;

public class SOAPMessageCreator {

    public static void main(String args[]) {
        try {
            SOAPMessageCreator client = new SOAPMessageCreator();

            //client.createMessageEnvelope();

            //client.createMessageBody();

            //client.createMessageHeader();

            client.createMessageFaultSOAP11();

            //client.createMessageFaultSOAP12();

            //client.createMessageWithAttachment();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void createMessageEnvelope() throws Exception {
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();

        AttachmentPart attachment = message.createAttachmentPart();
        attachment.setContent("", "text/plain");
        message.addAttachmentPart(attachment);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);
    }

    public SOAPMessage createMessageBody() throws Exception {
        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPBody soapBody = message.getSOAPPart().getEnvelope().getBody();        

        //Adding an element to a soap body; called as body block.
        QName qName = new QName("http://saaj.ws.learning.com/", "getEmployeeRequest", "ns1");
        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(qName);

        //Adding a child element to the body block.
        QName employeeId = new QName("employeeId");
        SOAPElement soapElement = soapBodyElement.addChildElement(employeeId);
        soapElement.addTextNode("666666");

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);

        return message;
    }

    public SOAPMessage createMessageHeader() throws Exception {
        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPHeader soapHeader = message.getSOAPPart().getEnvelope().getHeader();

        //Adding an element to a soap header; called as header block.
        QName qName = new QName("http://saaj.ws.learning.com/", "transaction", "ws");
        SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qName);

        //adding attributes to the header block
        soapHeaderElement.setAttribute("xmlns:ws", "http://wsbook.learning.com/transaction/");
        soapHeaderElement.setRole("http://www.w3.org/2003/05/soap-envelope/role/next");
        soapHeaderElement.setRelay(true);
        soapHeaderElement.setMustUnderstand(true);
        soapHeaderElement.setTextContent("567");

        //Adding another header block to a soap header
        QName logQName = new QName("http://saaj.ws.learning.com/", "logger", "log");
        SOAPHeaderElement logSOAPHeaderElement = soapHeader.addHeaderElement(logQName);
        logSOAPHeaderElement.setAttribute("xmlns:log", "http://wsbook.learning.com/logger/");
        logSOAPHeaderElement.setRole("http://www.w3.org/2003/05/soap-envelope/role/next");

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);

        return message;
    }

    public void createMessageFaultSOAP11() throws Exception {
        //Creates a soap message that is compatible with SOAP-1.1 specification
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        SOAPMessage message = factory.createMessage();

        SOAPBody soapBody = message.getSOAPPart().getEnvelope().getBody();
        //SOAPBody soapBody = message.getSOAPBody();
        SOAPFault soapFault = soapBody.addFault();

        QName faultName = new QName(SOAPConstants.URI_NS_SOAP_1_1_ENVELOPE, "Server");
        soapFault.setFaultCode(faultName);
        soapFault.setFaultString("Service not available");
        soapFault.setFaultActor("http://ws.learning.com/someactor");
        Detail detail = soapFault.addDetail();
        detail.setTextContent("I dont understand what it is?");

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);
    }

    public SOAPMessage createMessageFaultSOAP12() throws Exception {
        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();

        SOAPBody soapBody = message.getSOAPPart().getEnvelope().getBody();        
        SOAPFault soapFault = soapBody.addFault();

        QName faultName = new QName(SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE, "Sender");
        soapFault.setFaultCode(faultName);
        soapFault.addFaultReasonText("Invalid input XML", Locale.US);
        soapFault.setFaultRole("http://ws.learning.com/someactor");
        Detail detail = soapFault.addDetail();
        detail.setTextContent("Error in Input Data");

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------" + responseMessage);

        return message;
    }

    public SOAPMessage createMessageWithAttachment() throws Exception {
        //Creates a soap message that is compatible with SOAP-1.2 specification
        MessageFactory factory = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
        SOAPMessage message = factory.createMessage();
        SOAPPart soapPart = message.getSOAPPart();
        SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
        SOAPBody soapBody = soapEnvelope.getBody();

        //Creating the soap message body
        QName qName = new QName("http://saaj.ws.learning.com/", "getEmployeeRequest", "ns1");
        SOAPBodyElement soapBodyElement = soapBody.addBodyElement(qName);
        QName employeeId = new QName("employeeId");
        SOAPElement soapElement = soapBodyElement.addChildElement(employeeId);
        soapElement.addTextNode("666666");

        //Creating an attachment.
        AttachmentPart attachment = message.createAttachmentPart();
        String stringContent = "Update home address of an employee whose id is: 666666 - " +
                "2500 W.ROUNDBOUT CIR, CHANDLER, AZ, USA";

        //Id used to identify an attachment
        attachment.setContentId("home_address_update");

        //Setting the content type. it is using plain text.
        attachment.setContent(stringContent, "text/plain");

        //Addting attachment to a soap message
        message.addAttachmentPart(attachment);

        //Printing the response message on the console.
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        String responseMessage = new String(out.toByteArray());
        System.out.println("--------  Message ------ =" + responseMessage);

        return message;
    }

}