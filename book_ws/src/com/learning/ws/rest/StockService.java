package com.learning.ws.rest;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface StockService {

    @Produces("application/xml")
    public String getStockPrice(String symbol);
    
}
