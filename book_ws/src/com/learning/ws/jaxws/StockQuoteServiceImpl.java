package com.learning.ws.jaxws;

import javax.jws.WebService;
import javax.xml.ws.Action;

@WebService(name="StockQuoteService",
            serviceName="StockQuoteService",
            endpointInterface="com.learning.ws.jaxws.StockQuoteService")
public class StockQuoteServiceImpl implements StockQuoteService {

    public String getStockPrice(String symbol) throws Exception {
        System.out.println("-------- symbol -------" + symbol);
        if(symbol != null && symbol.equalsIgnoreCase("ABC")) {
            return "10000";
        } else {
            return "99";
        }
    }
}
