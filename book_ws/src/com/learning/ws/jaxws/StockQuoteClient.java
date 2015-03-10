package com.learning.ws.jaxws;

import javax.xml.ws.WebServiceRef;

public class StockQuoteClient {

//    @WebServiceRef(wsdlLocation=
//            "http://localhost:8080/wsbook/services/StockQuoteService?WSDL")    
    @WebServiceRef(name="services/StockQuoteService")
    static StockQuoteService service;

    public static void main(String[] args) {
        try {
            StockQuoteClient client = new StockQuoteClient();
            client.invokeService();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void invokeService() throws Exception {
        String port = service.getStockPrice("ABC");
        System.out.println("-------- symbol -------" + port);
    }

}
