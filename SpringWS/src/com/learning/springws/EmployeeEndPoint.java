package com.learning.springws;

import org.springframework.ws.server.endpoint.annotation.*;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.util.Iterator;

@Endpoint
public class EmployeeEndPoint {

    @PayloadRoot(namespace = "http://springws.ws.learning.com/emp/schemas",
                 localPart = "getEmployeeRequest")
    @ResponsePayload
    public Element getEmployee(@RequestPayload Element employeeRequest) throws Exception {
        System.out.println("-------- request Message ------" + employeeRequest.asXML());
        String employeeId = getEmployeeIdFromInputXML(employeeRequest.asXML());
        if (employeeId == null || employeeId == "") {
            employeeId = "99999999";
        }

        Element response = createResponseXML(employeeId);
        System.out.println("-------- response Message ------" + response.asXML());
        return response;
    }

    private Element createResponseXML(String employeeId) {
        Document document = DocumentHelper.createDocument();
        Element responseElement = document.addElement("getEmployeeResponse");
        Element rootElement = responseElement.addElement("employee");
        Element nameElement = rootElement.addElement("nameinfo");
        nameElement.addElement("id").addText(employeeId);
        nameElement.addElement("firstName").addText("John");
        nameElement.addElement("lastName").addText("Smith");

        Element homeAddressElement = rootElement.addElement("homeAddress");
        homeAddressElement.addElement("aptNumber").addText("2340");
        homeAddressElement.addElement("streetName").addText("W.Roundabout Cir");
        homeAddressElement.addElement("city").addText("Chandler");
        homeAddressElement.addElement("zipcode").addText("85225");
        homeAddressElement.addElement("state").addText("AZ");
        homeAddressElement.addElement("country").addText("USA");

        Element emailElement = rootElement.addElement("emailAddress");
        emailElement.addElement("personal").addText("wsbook@mymail.com");
        emailElement.addElement("office").addText("srinivas@abc.com");

        Element phoneElement = rootElement.addElement("phones");
        phoneElement.addElement("personal").addText("480-645-6753");
        phoneElement.addElement("office").addText("602-667-6782");
        return rootElement;
    }

    public String getEmployeeIdFromInputXML(String inputXML) throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(inputXML.getBytes()));
        Element root = document.getRootElement();
        String employeeId = null;
        for (Iterator i = root.elementIterator(); i.hasNext();) {
            Element element = (Element) i.next();
            for (int j = 0, size = element.nodeCount(); j < size; j++) {
                Node node = (Node) element.node(j);
                if (node instanceof Element) {
                    if ("employeeId".equalsIgnoreCase(node.getName())) {
                        employeeId = node.getText();
                    }
                }
            }
        }
        System.out.println("-------- employeeId: --------" + employeeId);
        return employeeId;
    }

}
