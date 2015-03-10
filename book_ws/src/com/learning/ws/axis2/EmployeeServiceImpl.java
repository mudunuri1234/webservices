package com.learning.ws.axis2;

public class EmployeeServiceImpl implements EmployeeService {

    public Employee getEmployee(String employeeId) throws EmployeeFault {
       System.out.println("--------- Address employeeId --------" + employeeId);
       Employee emp = new Employee();
       emp.setEmployeeId(employeeId);
       if("99999".equalsIgnoreCase(employeeId)) {
            emp.setFirstName("XXXXX");
            emp.setLastName("XXXXX");
       } else {
            emp.setFirstName("John");
            emp.setLastName("Smith");
       }
       return emp;
    }

    public String getEmployeeAddress(String employeeId) throws EmployeeFault {
        System.out.println("--------- Address employeeId --------" + employeeId);
        return "3943 Roundabout CIR, Chandler, Arizona, 85226";
    }

}
