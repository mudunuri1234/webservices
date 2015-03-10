package com.learning.ws.axis2.jaxws;

import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.OMAbstractFactory;

public class StockQuoteClient {

    public static void main(String args[]) throws java.lang.Exception {
        try {
            StockQuoteClient client = new StockQuoteClient();
            client.invokeService();
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService() throws java.lang.Exception {
        EndpointReference targetEPR =
                new EndpointReference("http://localhost:8080/flexweb/services/StockQuoteService");

        ServiceClient serviceClient = new ServiceClient();
        OMElement payload = getOMElement();
        Options options = new Options();
        options.setTo(targetEPR);
        serviceClient.setOptions(options);
        OMElement result = serviceClient.sendReceive(payload);
        //Parse the result to obtain the required data.
        System.out.println("---------- result --------" + result);
    }

    public static OMElement getOMElement() {
        OMFactory fac = OMAbstractFactory.getOMFactory();
        OMNamespace omNs = fac.createOMNamespace("http://jaxws.axis2.ws.learning.com", "ns");
        OMElement method = fac.createOMElement("getScripsList", omNs);
        //wraps the input parameters into <input/> element
        OMElement value = fac.createOMElement("input", omNs);
        //Sending input value as "Dividend"
        value.addChild(fac.createOMText(value, "Dividend"));
        method.addChild(value);

        return method;
    }

}
