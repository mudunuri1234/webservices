package com.learning.ws.jaxws;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.ws.handler.soap.SOAPMessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.WebServiceContext;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.Node;
import javax.xml.namespace.QName;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import java.io.ByteArrayOutputStream;
import java.util.*;

public class ValidationHandler implements SOAPHandler<SOAPMessageContext> {

//    @Resource
//    private WebServiceContext context;

    public ValidationHandler() {
        System.out.println("--------- ValidationHandler Constructor ----------");    
    }

    //callback method - invoked by the container.
//    @PostConstruct
//    private void init() {
//        System.out.println("--------- PostConstruct - Perform required initialization --------");
//    }

    @Override
	public boolean handleMessage(SOAPMessageContext context) {
		//message direction, true for outbound messages, false for inbound.
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        System.out.println("---------- ValidationHandler : isRequest() is: " + isRequest);

        if(!isRequest) {
            try {
                SOAPMessage message =  context.getMessage();
                //Printing the message on the console.
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                message.writeTo(out);
                String inboundMessage = new String(out.toByteArray());
                System.out.println("-------- ValidationHandler entire message ------" + inboundMessage);

                SOAPBody requestBody = message.getSOAPBody();
                Iterator iterator = requestBody.getChildElements();
                SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
                System.out.println("---------- body Element Name-------" + bodyElement.getNodeName());

                String elementName = bodyElement.getNodeName();
                if(elementName != null && elementName.contains("ns1:getEmployee")) {
                    for(Element result : getElements(bodyElement.getElementsByTagName("employeeId"))) {
                        String employeeId = getNamedElement(result, "employeeId").getTextContent();
                        Integer empId = new Integer(employeeId);
                        System.out.println(" --- empId---" + empId);
                        if(empId == 0) {
                            result.setTextContent("99999");
                        }
                    }
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }

        //continue with handler chain
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		System.out.println("--------- ValidationHandler : handleFault()......");
		return true;
	}

	@Override
	public void close(MessageContext context) {
		System.out.println("--------- ValidationHandler : close()......");
	}


//    @PreDestroy
//    private void doCleanUp() {
//        System.out.println("--------- ValidationHandler - PreDestroy -  doCleanUp() --------");
//    }

    @Override
	public Set<QName> getHeaders() {
		System.out.println("--------- ValidationHandler : getHeaders()......");
		return null;
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
