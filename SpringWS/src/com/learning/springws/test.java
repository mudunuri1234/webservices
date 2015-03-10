package com.learning.springws;

import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

public class test {

    public static void main(String args[]) {

        test t = new test();
        t.createResponseXML1("121313");

    }

    private Element createResponseXML1(String employeeId) {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("employee");
        Element nameElement = rootElement.addElement("nameinfo");
        nameElement.addElement("id").addText(employeeId);
        nameElement.addElement("firstName").addText("John");
        nameElement.addElement("lastName").addText("Smith");

        Element homeAddressElement = rootElement.addElement("homeAddress");
        homeAddressElement.addElement("aptNumber").addText("2340");
        homeAddressElement.addElement("streetName").addText("W.Roundabout Cir");
        homeAddressElement.addElement("city").addText("Chandler");
        homeAddressElement.addElement("zipcode").addText("85226");
        homeAddressElement.addElement("state").addText("AZ");
        homeAddressElement.addElement("country").addText("UAS");

        Element emailElement = rootElement.addElement("emailAddress");
        emailElement.addElement("personal").addText("wsbook@mymail.com");
        emailElement.addElement("office").addText("srinivas@abc.com");

        Element phoneElement = rootElement.addElement("phones");
        phoneElement.addElement("personal").addText("480-645-6753");
        phoneElement.addElement("office").addText("602-667-6782");

        //Convert document to String
        //String outputXML = document.asXML();
        System.out.println("----- outputXML -----" + rootElement.asXML());
        return rootElement;
    }

}
