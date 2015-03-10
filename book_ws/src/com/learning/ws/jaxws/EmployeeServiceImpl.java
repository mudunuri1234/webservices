package com.learning.ws.jaxws;

import javax.jws.*;
import javax.xml.ws.*;
import javax.annotation.PostConstruct;

@WebService(name="EmployeeService",
            //targetNamespace="http://jaxws.ws.learning.com/",
            serviceName="employeeService",
            portName="EmployeeServicePort",
            //wsdlLocation="",
            endpointInterface="com.learning.ws.jaxws.EmployeeService")
@BindingType(javax.xml.ws.soap.SOAPBinding.SOAP11HTTP_BINDING)
public class EmployeeServiceImpl implements EmployeeService {

//    @Resource
//    private WebServiceContext context;
//
//    public EmployeeServiceImpl() {
//        System.out.println("---------Constructor called --------");
//    }
//
//    @PostConstruct
//    private void init() {
//        System.out.println("--------- Init Perform required initialization --------");
//    }
//
//    @PostConstruct
//    private void start() {
//        System.out.println("--------- Start Perform required initialization --------");
//    }

    public Employee getEmployee(String employeeId) throws EmployeeFault {
       System.out.println("--------- employeeId --------" + employeeId);
//       if(context != null) {
//           System.out.println(" ----- UserPrincipal -----" + context.getUserPrincipal());
//           System.out.println(" ----- isUserInRole  -----" + context.isUserInRole("admin"));
//           MessageContext messageContext = context.getMessageContext();
//           System.out.println(" ----- SERVLET_REQUEST ----  " + messageContext.SERVLET_REQUEST);
//       }

       if(employeeId == null) {
            throw new EmployeeFault("Invalid input received");
       }

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
  
    public String getEmployeeAddressInfo(String employeeId) throws Exception {
        System.out.println("--------- Address employeeId --------" + employeeId);
        String address = "3943 Roundabout CIR, Chandler, Arizona, 85226";
        return address;
    }

    public void deleteEmployee(String employeeId) {
        System.out.println("--------- Delete Employee --------" + employeeId);
        //Implement your logic here to delete an employee
    }

    public String getEmployerInformation(String employeeId, String state) throws Exception {
        String employer = "Bank of Chandler , Chandler, Arizona, 85226";
        return employer;
    }

//    @PreDestroy
//    private void doCleanUp() {
//        System.out.println("--------- Perform clean-up after you are done with it --------");
//    }

}
