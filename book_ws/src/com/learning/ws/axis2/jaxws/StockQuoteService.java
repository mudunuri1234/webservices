package com.learning.ws.axis2.jaxws;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface StockQuoteService {

    List getScripsList(String symbol) throws Exception;
    
}
