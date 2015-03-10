/*
 * XML Type:  EmployeeDemographicOutput_Type
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.impl;
/**
 * An XML EmployeeDemographicOutput_Type(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/).
 *
 * This is a complex type.
 */
public class EmployeeDemographicOutputTypeImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType
{
    
    public EmployeeDemographicOutputTypeImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName OUPUTDATA$0 = 
        new javax.xml.namespace.QName("", "ouputData");
    
    
    /**
     * Gets the "ouputData" element
     */
    public java.lang.String getOuputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUPUTDATA$0, 0);
            if (target == null)
            {
                return null;
            }
            return target.getStringValue();
        }
    }
    
    /**
     * Gets (as xml) the "ouputData" element
     */
    public org.apache.xmlbeans.XmlString xgetOuputData()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OUPUTDATA$0, 0);
            return target;
        }
    }
    
    /**
     * Sets the "ouputData" element
     */
    public void setOuputData(java.lang.String ouputData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(OUPUTDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(OUPUTDATA$0);
            }
            target.setStringValue(ouputData);
        }
    }
    
    /**
     * Sets (as xml) the "ouputData" element
     */
    public void xsetOuputData(org.apache.xmlbeans.XmlString ouputData)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.XmlString target = null;
            target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(OUPUTDATA$0, 0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(OUPUTDATA$0);
            }
            target.set(ouputData);
        }
    }
}
