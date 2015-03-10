package com.learning.ws.jaxws.wsdl2java;

import javax.xml.ws.BindingProvider;

public class Client {

    public static void main(String args[]) throws Exception {
        try {
            Client client = new Client();
            client.invokeService();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

//    private void invokeService1() throws Exception {
//        URL url = new URL("http://localhost:8080/wsbook/services/employeeService?wsdl");
//        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeService");
//        Service service = Service.create(url, qname);
//        EmployeeService employeeService = service.getPort(EmployeeService.class);
//
//        //Invoking the end point method - getEmployeeAddress()
//        String address = employeeService.getEmployeeAddress("823147");
//        System.out.println("Address is : " + address);
//
//        //Invoking the end point method - getEmployee()
//        Employee emp = employeeService.getEmployee("133334");
//        System.out.println("Employee Id:" + emp.getEmployeeId() +
//                "-- First Name --" + emp.getFirstName() + "-- Last Name --" + emp.getLastName());
//    }

    private static void invokeService() throws Exception {
      	//create the client stub
      	EmployeeService_Service service = new EmployeeService_Service();
        EmployeeService stub = service.getEmployeeServicePort();

        String target = "http://localhost:8080/wsbook/services/employeeService";
        BindingProvider provider = (BindingProvider) stub;
        provider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, target);

       //Invoking the end point method - getEmployeeAddress()
        String address = stub.getEmployeeAddress("823147");
        System.out.println("Address is : " + address);

        //Invoking the end point method - getEmployee()
        Employee emp = stub.getEmployee("133334");
        System.out.println("Employee Id:" + emp.getEmployeeId() +
                "-- First Name --" + emp.getFirstName() + "-- Last Name --" + emp.getLastName());
    }


}
