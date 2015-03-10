package com.learning.springws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

@Endpoint
public class StockServiceEndpoint {

    @PayloadRoot(namespace = "http://springws.ws.learning.com/stock/schemas",
                 localPart = "getStockRequest")
    @ResponsePayload
    public StockResponse getStockInformaton(@RequestPayload StockRequest stockRequest) throws Exception {
        System.out.println("----- Inside -----" + stockRequest.getSymbol());
        //Getting the input data from client request
        String symbol = stockRequest.getSymbol();

        //JAXB annotated response object
        StockResponse response = new StockResponse();
        
        //Apply the business logic based on input received.
        if (symbol != null && symbol.equalsIgnoreCase("GLD")) {
            response.setTodayPrice("32.15");
            response.setChange("1.13");
        } else {
            response.setTodayPrice("XXXX");
            response.setChange("XXXX");
        }

        //marshalling the Java object to a XML; to print the XML
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(StockResponse.class);
        Marshaller m = context.createMarshaller();
        m.marshal(response, writer);
        System.out.println("----- Response -----" + writer.toString());

        return response;
    }

}
