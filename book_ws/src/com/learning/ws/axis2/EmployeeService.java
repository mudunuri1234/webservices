package com.learning.ws.axis2;

public interface EmployeeService {

    Employee getEmployee(String employeeId) throws EmployeeFault;

    String getEmployeeAddress(String employeeId) throws EmployeeFault;

}
