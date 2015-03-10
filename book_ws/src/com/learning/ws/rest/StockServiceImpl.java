package com.learning.ws.rest;

import javax.ws.rs.*;

public class StockServiceImpl {

    @Produces("text/plain")
    public String getStockPrice(String symbol) {
        System.out.println("--------- symbol ---------" + symbol);
        if(symbol.equalsIgnoreCase("GLD")) {
            return "1800.30";
        } else if(symbol.equalsIgnoreCase("XXX")) {
             return "10.0";
        }
        return symbol;
    }

}
