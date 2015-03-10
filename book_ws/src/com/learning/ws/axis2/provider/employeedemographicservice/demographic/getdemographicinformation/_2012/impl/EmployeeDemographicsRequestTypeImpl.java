/*
 * XML Type:  EmployeeDemographicsRequest_Type
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.impl;
/**
 * An XML EmployeeDemographicsRequest_Type(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/).
 *
 * This is a complex type.
 */
public class EmployeeDemographicsRequestTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicsRequestType
{
    
    public EmployeeDemographicsRequestTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName INPUTDATA$0 = 
        new javax.xml.namespace.QName("", "inputData");
    
    
    /**
     * Gets the "inputData" element
     */
    public java.lang.String getInputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INPUTDATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "inputData" element
     */
    public org.apache.xmlbeans.XmlString xgetInputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INPUTDATA$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "inputData" element
     */
    public void setInputData(java.lang.String inputData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(INPUTDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(INPUTDATA$0);
            }
            target.setStringValue(inputData);
        }
    }
    
    /**
     * Sets (as xml) the "inputData" element
     */
    public void xsetInputData(org.apache.xmlbeans.XmlString inputData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(INPUTDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(INPUTDATA$0);
            }
            target.set(inputData);
        }
    }
}
