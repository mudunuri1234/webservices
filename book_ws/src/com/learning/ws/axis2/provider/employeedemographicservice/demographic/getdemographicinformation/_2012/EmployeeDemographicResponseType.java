/*
 * XML Type:  EmployeeDemographicResponse_Type
 * Namespace: http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/
 * Java type: com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType
 *
 * Automatically generated - do not modify.
 */
package com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012;


/**
 * An XML EmployeeDemographicResponse_Type(@http://axis2.ws.learning.com/provider/employeeDemographicService/demographic/getDemographicInformation/2012/).
 *
 * This is a complex type.
 */
public interface EmployeeDemographicResponseType extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(EmployeeDemographicResponseType.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s11E7E581990E99C71270A8E93273274F").resolveHandle("employeedemographicresponsetype19fctype");
    
    /**
     * Gets the "info" element
     */
    com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType getInfo();
    
    /**
     * True if has "info" element
     */
    boolean isSetInfo();
    
    /**
     * Sets the "info" element
     */
    void setInfo(com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType info);
    
    /**
     * Appends and returns a new empty "info" element
     */
    com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicOutputType addNewInfo();
    
    /**
     * Unsets the "info" element
     */
    void unsetInfo();
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType newInstance() {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.learning.ws.axis2.provider.employeedemographicservice.demographic.getdemographicinformation._2012.EmployeeDemographicResponseType) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
