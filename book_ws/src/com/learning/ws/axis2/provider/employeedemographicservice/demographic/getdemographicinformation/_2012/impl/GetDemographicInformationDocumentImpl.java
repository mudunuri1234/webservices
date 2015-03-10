/*
 * An XML document type.
 * Localname: getDemographicInformation
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationDocument
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.impl;
/**
 * A document containing one getDemographicInformation(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/) element.
 *
 * This is a complex type.
 */
public class GetDemographicInformationDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.GetDemographicInformationDocument
{
    
    public GetDemographicInformationDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName GETDEMOGRAPHICINFORMATION$0 = 
        new javax.xml.namespace.QName("http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/", "getDemographicInformation");
    
    
    /**
     * Gets the "getDemographicInformation" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType getGetDemographicInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType)get_store().find_element_user(GETDEMOGRAPHICINFORMATION$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "getDemographicInformation" element
     */
    public void setGetDemographicInformation(com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType getDemographicInformation)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType)get_store().find_element_user(GETDEMOGRAPHICINFORMATION$0, 0);
            if (target == null)
            {
                target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType)get_store().add_element_user(GETDEMOGRAPHICINFORMATION$0);
            }
            target.set(getDemographicInformation);
        }
    }
    
    /**
     * Appends and returns a new empty "getDemographicInformation" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType addNewGetDemographicInformation()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType)get_store().add_element_user(GETDEMOGRAPHICINFORMATION$0);
            return target;
        }
    }
}
