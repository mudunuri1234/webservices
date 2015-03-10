package com.learning.ws.axis2.jaxws;

import javax.jws.WebService;
import java.util.List;
import java.util.ArrayList;

@WebService(name="StockQuoteService",
            serviceName="StockQuoteService",
            endpointInterface="com.learning.ws.axis2.jaxws.StockQuoteService")
public class StockQuoteServiceImpl implements StockQuoteService {

    public List getScripsList(String type) throws Exception {
        System.out.println("--------- type --------" + type);
        List scripsList = new ArrayList();
        if("Dividend".equalsIgnoreCase(type)) {
            scripsList.add("WFC");
            scripsList.add("SLV");
            scripsList.add("GLD");
            scripsList.add("PALL");
        }
        return scripsList;
    }

}
