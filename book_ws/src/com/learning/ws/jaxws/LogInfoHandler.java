package com.learning.ws.jaxws;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPMessage;
import java.util.Iterator;
import java.io.ByteArrayOutputStream;

public class LogInfoHandler implements Handler {

    public boolean handleMessage(MessageContext context) {
        SOAPMessageContext messageContext = (SOAPMessageContext) context;
        System.out.println("--------- Request ---------- " + messageContext.getMessage().toString());
        try {
            SOAPMessage message =  messageContext.getMessage();

            //Printing the message on the console.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String responseMessage = new String(out.toByteArray());
            System.out.println("--------  message in Handler ------" + responseMessage);

            SOAPBody requestBody = messageContext.getMessage().getSOAPPart().getEnvelope().getBody();
            Iterator iterator = requestBody.getChildElements();
            SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
            System.out.println("--------  bodyElement ------" + bodyElement.getNodeName());

        } catch(Exception ex) {
        ex.printStackTrace();
        }
        return true;
    }

    public boolean handleFault(MessageContext context) {
        SOAPMessageContext messageContext = (SOAPMessageContext) context;
        System.out.println("---------- Fault: ----------"+messageContext.getMessage().toString());
        return true;
    }

    public void close(javax.xml.ws.handler.MessageContext context) {
        System.out.println("--------- inside close --------");
        //context.clear();
    }

}
