package com.learning.springws;

import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.WebServiceMessage;

import java.io.ByteArrayOutputStream;

public class LogMessageHandler implements EndpointInterceptor {

    public boolean handleRequest(MessageContext messageContext, Object o) throws Exception {
        System.out.println("--------  handleRequest ------" + messageContext.hasResponse());
        WebServiceMessage requestMessage = messageContext.getRequest();
        if (requestMessage != null) {
            //Printing the message on the console.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            requestMessage.writeTo(out);
            String request = new String(out.toByteArray());
            System.out.println("--------  Endpoint request ------" + request);
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext, Object o) throws Exception {
        System.out.println("--------  handleResponse ------" + messageContext.hasResponse());
        WebServiceMessage responseMessage = messageContext.getResponse();
        if (responseMessage != null) {
            //Printing the message on the console.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            responseMessage.writeTo(out);
            String response = new String(out.toByteArray());
            System.out.println("--------  Endpoint response ------" + response);
        }
        return true;
    }

    public boolean handleFault(MessageContext messageContext, Object o) throws Exception {
        return true;
    }

    public void afterCompletion(MessageContext messageContext, Object o, Exception e) throws Exception {

    }

}