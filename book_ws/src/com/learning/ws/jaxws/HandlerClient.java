package com.learning.ws.jaxws;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class HandlerClient {

    public static void main(String args[]) throws Exception {
        try {
            HandlerClient client = new HandlerClient();
            client.invokeService();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService() throws Exception {
        URL url = new URL("http://localhost:8080/wsbook/services/employee?wsdl");
        QName qname = new QName("http://jaxws.ws.learning.com/", "employeeService");
        Service service = Service.create(url, qname);
        EmployeeService employeeService = service.getPort(EmployeeService.class);

        Employee emp = employeeService.getEmployee("000000");
        System.out.println("Employee Id:" + emp.getEmployeeId() + 
                        "-- First Name --" + emp.getFirstName() +
                        "-- Last Name --" + emp.getLastName());
    }

}
