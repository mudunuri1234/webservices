package com.learning.springws;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="getStockRequest",
                namespace="http://springws.ws.learning.com/stock/schemas")
@XmlType(name="StockRequest") 
public class StockRequest {

    private static final long serialVersionUID = 1L;
    private String symbol;

    @XmlElement(name="symbol")
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}

