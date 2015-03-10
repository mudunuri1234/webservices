/*
 * XML Type:  EmployeeDemographicResponse_Type
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.impl;
/**
 * An XML EmployeeDemographicResponse_Type(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/).
 *
 * This is a complex type.
 */
public class EmployeeDemographicResponseTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType
{
    
    public EmployeeDemographicResponseTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INFO$0 = 
        new javax.xml.namespace.QName("", "info");
    
    
    /**
     * Gets the "info" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType getInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType)get_store().find_element_user(INFO$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * True if has "info" element
     */
    public boolean isSetInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(INFO$0) != 0;
        }
    }
    
    /**
     * Sets the "info" element
     */
    public void setInfo(com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType info)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType)get_store().find_element_user(INFO$0, 0);
            if (target == null)
            {
                target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType)get_store().add_element_user(INFO$0);
            }
            target.set(info);
        }
    }
    
    /**
     * Appends and returns a new empty "info" element
     */
    public com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType addNewInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType target = null;
            target = (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType)get_store().add_element_user(INFO$0);
            return target;
        }
    }
    
    /**
     * Unsets the "info" element
     */
    public void unsetInfo()
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(INFO$0, 0);
        }
    }
}
