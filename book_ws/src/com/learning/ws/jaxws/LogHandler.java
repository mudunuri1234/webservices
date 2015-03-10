package com.learning.ws.jaxws;

import java.util.Set;
import java.io.ByteArrayOutputStream;
import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.soap.SOAPMessage;

public class LogHandler implements SOAPHandler<SOAPMessageContext> {

    public LogHandler() {}

    @Override
	public boolean handleMessage(SOAPMessageContext context) {
		//message direction, true for outbound messages, false for inbound.
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("---------- LogHandler : isRequest is: " + isRequest);
        try {
            SOAPMessage message =  context.getMessage();
            //Printing the message on the console.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            message.writeTo(out);
            String responseMessage = new String(out.toByteArray());
            System.out.println("-------- LogHandler entire message ------" + responseMessage);
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        //continue other handler chain
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("--------- LogHandler : handleFault()......");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("--------- LogHandler : close()......");
	}

	@Override
	public Set<QName> getHeaders() {
		System.out.println("--------- LogHandler : getHeaders()......");
		return null;
	}
}
