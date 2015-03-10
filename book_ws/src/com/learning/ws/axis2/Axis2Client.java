package com.learning.ws.axis2;

import javax.xml.namespace.QName;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.learning.ws.axis2.provider.employeedemographicservice.demographic._2012.EmployeeDemographicServiceStub;
import com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationDocument;
import com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationResponseDocument;

public class Axis2Client {

    public static void main(String args[]) throws java.lang.Exception {
        try {
            Axis2Client client = new Axis2Client();
            client.invokeService();
            //client.invokeService1();
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }
    }

    //This is working only with axiom 1.2.8 + axis 1.5.1 jars
    private void invokeService() throws java.lang.Exception {
        RPCServiceClient serviceClient = new RPCServiceClient();
        Options options = serviceClient.getOptions();
        EndpointReference targetEPR =
                new EndpointReference("http://localhost:8080/flexweb/services/employeeService");
        options.setTo(targetEPR);

        // Getting the weather
        QName getEmployee = new QName("http://axis2.ws.learning.com", "getEmployee");
        Object[] inputParams = new Object[]{"123456"};
        Class[] returnTypes = new Class[]{Employee.class};
        Object[] response = serviceClient.invokeBlocking(getEmployee, inputParams, returnTypes);
        Employee employee = (Employee) response[0];
        System.out.println("Employee Id: " + employee.getEmployeeId() +
                "Last Name, " + employee.getLastName() +
                "First Name, " + employee.getFirstName());


        QName getEmployeeAddress = new QName("http://axis2.ws.learning.com", "getEmployeeAddress");
        inputParams = new Object[]{"123456"};
        returnTypes = new Class[]{String.class};
        response = serviceClient.invokeBlocking(getEmployeeAddress, inputParams, returnTypes);
        String address = (String) response[0];

        System.out.println("-------- address  ---------- " + address);
    }

    private void invokeService1() throws java.lang.Exception {
        /** Axis client configuration file location for logging SOAP messages. */
        //System.setProperty("-Daxis.ClientConfigFile", "client-config.wsdd");

        //Sending the input data as XML to service endpoint
        String inputData = createInputXML("123456");
        EmployeeDemographicServiceStub stub = new EmployeeDemographicServiceStub("http://localhost:8080/flexweb/services/employeeDmographicService");
        GetDemographicInformationDocument input = GetDemographicInformationDocument.Factory.newInstance();
        input.addNewGetDemographicInformation().setInputData(inputData);

        //Get the output data as XML from service end point
        GetDemographicInformationResponseDocument response = stub.getDemographicInformation(input);
        System.out.println("----- response -----" + response);
        String outputData = response.getGetDemographicInformationResponse().getInfo().getOuputData();
        System.out.println("-------- outputData  --------" + outputData);
    }

    private String createInputXML(String employeeId) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("inputData");
        Element employeeElement = rootElement.addElement("employee");
        employeeElement.addElement("employeeId").addText(employeeId);
        //converting input XML to a String
        System.out.println("-------- String  ---------- " + document.asXML());
        return document.asXML();
    }

}