package com.learning.ws.jaxws;

import javax.jws.WebService;
import javax.xml.ws.Action;

@WebService
public interface StockQuoteService {

    @Action(input="http://jaxws.ws.learning.com/inputAction",
            output="http://jaxws.ws.learning.com/outputAction")
    String getStockPrice(String symbol) throws Exception;

}
