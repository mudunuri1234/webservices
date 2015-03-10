package com.learning.ws.jaxws.wsdl2java;

import javax.jws.*;

@WebService(name="EmployeeService",
            targetNamespace="http://jaxws.ws.learning.com/",
            serviceName="employeeService",
            portName="EmployeeServicePort",
            wsdlLocation="",
            endpointInterface="com.learning.ws.jaxws.wsdl2java.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    public Employee getEmployee(String employeeId) {
       System.out.println("--------- employeeId --------" + employeeId);
       Employee emp = new Employee();
       emp.setEmployeeId(employeeId);
       emp.setFirstName("John");
       emp.setLastName("Smith");

       return emp;
    }
  
    public String getEmployeeAddress(String employeeId)  {
        System.out.println("--------- Address employeeId --------" + employeeId);
        String address = "3943 W.Roundabout CIR, Chandler, Arizona, 85226";
        return address;
    }

    public void deleteEmployee(String employeeId) {
        System.out.println("--------- Delete Employee --------" + employeeId);
        //Implement your logic here to delete an employee
    }

    public String getEmployerInformation(String employeeId, String state)  {
        String employer = "Chandler Bank, Chandler, Arizona, 85226";
        return employer;
    }

}
