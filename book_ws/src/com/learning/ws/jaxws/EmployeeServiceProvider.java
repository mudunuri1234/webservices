package com.learning.ws.jaxws;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceProvider;
import java.util.*;
import java.io.ByteArrayOutputStream;

@WebServiceProvider(serviceName="employeeServiceProvider")
@ServiceMode(value= Service.Mode.MESSAGE)
public class EmployeeServiceProvider implements Provider<SOAPMessage> {

    //Default public constructor
    public EmployeeServiceProvider() {}

    //invoke method - this is called for each request
    public SOAPMessage invoke(SOAPMessage request) {
        SOAPMessage response = null;
        try {
            //Printing the input request message.
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            request.writeTo(out);
            String requestMessage = new String(out.toByteArray());
            System.out.println("-------- request Message ------" + requestMessage);

            SOAPBody requestBody = request.getSOAPBody();
            Iterator iterator = requestBody.getChildElements();
            SOAPBodyElement bodyElement = (SOAPBodyElement) iterator.next();
            System.out.println("---------- body Element Name-------" + bodyElement.getNodeName());

            System.out.println("---- Local Name -----" + requestBody.getElementName().getLocalName());
            String employeeId = null;
            if(requestBody.getElementName().getLocalName().equals("Body")) {
                for(Element result : getElements(bodyElement.getElementsByTagName("employeeId"))) {
                    System.out.println("-- here ---" + result.getTextContent());
                    employeeId = getNamedElement(result, "employeeId").getTextContent();
                    System.out.println("-- employeeId ---" + employeeId);
                }
            }

            //Build your logic here based on input data received.
            MessageFactory mf = MessageFactory.newInstance();
            SOAPFactory sf = SOAPFactory.newInstance();
            //SOAPMessage response = null;
            if(employeeId != null && employeeId.equalsIgnoreCase("12345678")) {
                System.out.println("---- Response -----" );
                //Creating the response message
                response = mf.createMessage();
                SOAPBody respBody = response.getSOAPBody();
                SOAPElement responseElement = respBody.addChildElement("getEmployeeResponse");
                SOAPElement firstNameContent = responseElement.addChildElement("firstName");
                firstNameContent.setValue("John");
                SOAPElement lastNameContent = responseElement.addChildElement("lastName");
                lastNameContent.setValue("Smith");
                response.saveChanges();
            }

            //Printing the output response message.
            ByteArrayOutputStream out1 = new ByteArrayOutputStream();
            response.writeTo(out1);
            String responseMessage = new String(out1.toByteArray());
            System.out.println("--------  Response Message ------" + responseMessage);

            return response;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return response;
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
