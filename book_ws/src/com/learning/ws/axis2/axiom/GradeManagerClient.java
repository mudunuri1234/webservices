package com.learning.ws.axis2.axiom;

import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Options;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMNamespace;

public class GradeManagerClient {

    public static void main(String args[]) {
        try {
            GradeManagerClient client = new GradeManagerClient();
            client.invokeService();
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService() throws java.lang.Exception {
        EndpointReference targetEPR =
                new EndpointReference("http://localhost:8080/flexweb/services/GradeManagerService");

        //creating the request payload
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://jaxws.axis2.ws.learning.com", "ns");
        OMElement payload = fac.createOMElement("getSubjects", omNs);
        //wraps the input parameters into <grade/> element
        OMElement value = fac.createOMElement("grade", omNs);
        //Sending input value as "9"
        value.addChild(fac.createOMText(value, "9"));
        payload.addChild(value);

        ServiceClient serviceClient = new ServiceClient();
        Options options = new Options();
        options.setTo(targetEPR);
        serviceClient.setOptions(options);
        OMElement response = serviceClient.sendReceive(payload);
        //Parse the result to obtain the required data.
        System.out.println("---------- response --------" + response);
    }

//    public static OMElement getOMElement() {
//        OMFactory fac = OMAbstractFactory.getOMFactory();
//        OMNamespace omNs = fac.createOMNamespace("http://jaxws.axis2.ws.learning.com", "ns");
//        OMElement method = fac.createOMElement("getSubjects", omNs);
//        //wraps the input parameters into <grade/> element
//        OMElement value = fac.createOMElement("grade", omNs);
//        //Sending input value as "9"
//        value.addChild(fac.createOMText(value, "9"));
//        method.addChild(value);
//
//        return method;
//    }

}
