
/*
 * 
 */

package com.learning.ws.jaxws.wsdl2java;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.2.5
 * Sun Dec 25 07:32:04 MST 2011
 * Generated source version: 2.2.5
 * 
 */


@WebServiceClient(name = "employeeService", 
                  wsdlLocation = "file:/C:/projects/Learning/book_ws/build/employee.wsdl",
                  targetNamespace = "http://jaxws.ws.learning.com/") 
public class EmployeeService_Service extends Service {

    public final static URL WSDL_LOCATION;
    public final static QName SERVICE = new QName("http://jaxws.ws.learning.com/", "employeeService");
    public final static QName EmployeeServicePort = new QName("http://jaxws.ws.learning.com/", "EmployeeServicePort");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/projects/Learning/book_ws/build/employee.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/C:/projects/Learning/book_ws/build/employee.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public EmployeeService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public EmployeeService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public EmployeeService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }

    /**
     * 
     * @return
     *     returns EmployeeService
     */
    @WebEndpoint(name = "EmployeeServicePort")
    public EmployeeService getEmployeeServicePort() {
        return super.getPort(EmployeeServicePort, EmployeeService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns EmployeeService
     */
    @WebEndpoint(name = "EmployeeServicePort")
    public EmployeeService getEmployeeServicePort(WebServiceFeature... features) {
        return super.getPort(EmployeeServicePort, EmployeeService.class, features);
    }

}
