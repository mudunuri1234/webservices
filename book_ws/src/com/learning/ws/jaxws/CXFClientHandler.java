package com.learning.ws.jaxws;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CXFClientHandler {

    private CXFClientHandler() { }

    public static void main(String args[]) throws Exception {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[] {"applicationContext-client.xml"});

        EmployeeService employeeService = (EmployeeService) context.getBean("springHandlerClient");

        Employee emp = employeeService.getEmployee("000000");
        System.out.println("Employee Id:" + emp.getEmployeeId() +
                        "-- First Name --" + emp.getFirstName() +
                        "-- Last Name --" + emp.getLastName());
        System.exit(0);
    }

}
