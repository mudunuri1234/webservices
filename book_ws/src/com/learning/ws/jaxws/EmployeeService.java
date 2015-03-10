package com.learning.ws.jaxws;

import javax.jws.WebParam.Mode;
import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = Style.DOCUMENT, parameterStyle = ParameterStyle.BARE, use = Use.LITERAL)
//@SOAPBinding(style = SOAPBinding.Style.RPC, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED, use = SOAPBinding.Use.LITERAL)
//@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.BARE, use = Use.LITERAL)
//@HandlerChain(file="http://localhost:8080/wsbook/demo/handlerchain.xml")
public interface EmployeeService {

    @WebMethod(operationName="getEmployee")
    Employee getEmployee(@WebParam (name="employeeId") String employeeId) throws EmployeeFault;

    //@WebMethod(operationName="getEmployeeAddress", exclude=false, action="employee")
    //@WebResult(name="addressMessage", partName="addressMessagePart", targetNamespace="addressMessage", header=true)
    //String getEmployeeAddressInfo(@WebParam(name="empId", mode= Mode.IN, partName="empParam", targetNamespace="empParam", header=true) String employeeId) throws Exception;
    //String getEmployeeAddressInfo(@WebParam(name="empId", mode= Mode.IN, partName="empParam", targetNamespace="empParam", header=true) String employeeId) throws Exception;
    @WebMethod(operationName="getEmployeeAddress")
    @Action(input="employeeId", output="address")
    String getEmployeeAddressInfo(@WebParam(name="empId", mode= Mode.IN) String employeeId) throws Exception;

    String getEmployerInformation(@WebParam(name="empId", mode= Mode.IN) String employeeId, @WebParam(name="state", mode= Mode.IN) String state) throws Exception;

    @WebMethod(operationName="deleteEmployee")
    void deleteEmployee(@WebParam (name="employeeId") String employeeId);

}