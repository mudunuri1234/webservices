/**
 * EmployeeDemographicServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.1  Built on : Oct 19, 2009 (10:59:00 EDT)
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic._2012;

import com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationResponseDocument;
import com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationDocument;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;

/**
 * EmployeeDemographicServiceSkeleton java skeleton for the axisService
 */
public class EmployeeDemographicServiceSkeleton {


    /**
     * Auto generated method signature
     *
     * @param getDemographicInformation
     */

    public GetDemographicInformationResponseDocument getDemographicInformation(GetDemographicInformationDocument getDemographicInformation) {
        String inputData = getDemographicInformation.getGetDemographicInformation().getInputData();
        String employeeId = getEmployeeIdFromInputXML(inputData);        
        System.out.println("---------  employeeId --------" + employeeId);
        GetDemographicInformationResponseDocument response = GetDemographicInformationResponseDocument.Factory.newInstance();
        String outputXML = getDemographicData(employeeId);
        response.addNewGetDemographicInformationResponse().addNewInfo().setOuputData(outputXML);
        return response;


        //TODO : fill this with the necessary business logic
        //throw new java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#getDemographicInformation");
    }

    private String getDemographicData(String employeeId) {
        //Implement your logic here. Get the data from various sources, build XML.
        return createResponseXML(employeeId);
    }

    private String createResponseXML(String employeeId) {
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
        String outputXML = document.asXML();
        System.out.println("----- outputXML -----" + outputXML);
        return outputXML;
    }

    private String getEmployeeIdFromInputXML(String inputXML) {
        try {
            SAXReader reader = new SAXReader();
            Document document = reader.read(new ByteArrayInputStream(inputXML.getBytes()));
            Node node = document.selectSingleNode("//employee/employeeId");
            System.out.println("------ employeeId ----" + node.getText());
            return node.getText();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return "99999";
    }

}
    