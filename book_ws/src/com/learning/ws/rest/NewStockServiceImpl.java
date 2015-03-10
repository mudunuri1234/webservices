package com.learning.ws.rest;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;

@Path("/stockservice/")
public class NewStockServiceImpl extends StockServiceImpl implements StockService {

    @GET
    @Path("/symbol/{symbol}")
    public String getStockPrice(@PathParam("symbol") String symbol) {
        System.out.println("--------- NEW symbol ---------" + symbol);
        if(symbol.equalsIgnoreCase("SLV")) {
            return "32.30";
        } else if(symbol.equalsIgnoreCase("YYYY")) {
             return "10.0";
        }
        return symbol;
    }
    
}
