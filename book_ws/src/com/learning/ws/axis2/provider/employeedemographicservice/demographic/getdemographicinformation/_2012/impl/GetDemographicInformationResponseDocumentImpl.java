/*
 * An XML document type.
 * Localname: getDemographicInformationResponse
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationResponseDocument
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.impl;
/**
 * A document containing one getDemographicInformationResponse(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/) element.
 *
 * This is a complex type.
 */
public class GetDemographicInformationResponseDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationResponseDocument
{
    
    public GetDemographicInformationResponseDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETDEMOGRAPHICINFORMATIONRESPONSE$0 = 
        new javax.xml.namespace.QName("http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/", "getDemographicInformationResponse");
    
    
    /**
     * Gets the "getDemographicInformationResponse" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType getGetDemographicInformationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType)get_store().find_element_user(GETDEMOGRAPHICINFORMATIONRESPONSE$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getDemographicInformationResponse" element
     */
    public void setGetDemographicInformationResponse(com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType getDemographicInformationResponse)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType)get_store().find_element_user(GETDEMOGRAPHICINFORMATIONRESPONSE$0, 0);
            if (target == null)
            {
                target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType)get_store().add_element_user(GETDEMOGRAPHICINFORMATIONRESPONSE$0);
            }
            target.set(getDemographicInformationResponse);
        }
    }
    
    /**
     * Appends and returns a new empty "getDemographicInformationResponse" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType addNewGetDemographicInformationResponse()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType)get_store().add_element_user(GETDEMOGRAPHICINFORMATIONRESPONSE$0);
            return target;
        }
    }
}
