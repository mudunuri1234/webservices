package com.learning.springws;

import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.WebServiceMessage;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ClientLogMessageHandler implements ClientInterceptor {

    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        WebServiceMessage requestMessage = messageContext.getRequest();
        try {
            if (requestMessage != null) {
                //Printing the message on console.
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                requestMessage.writeTo(out);
                String request = new String(out.toByteArray());
                System.out.println("--------  Client Request ------" + request);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        WebServiceMessage responseMessage = messageContext.getResponse();
        try {
            if (responseMessage != null) {
                //Printing the message on console.
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                responseMessage.writeTo(out);
                String response = new String(out.toByteArray());
                System.out.println("--------  Service Response ------" + response);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return true;
    }

    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

}
