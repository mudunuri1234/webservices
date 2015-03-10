package com.learning.springws;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getStockResponse", namespace = "http://springws.ws.learning.com/stock/schemas")
@XmlType(name="StockResponse", propOrder = {"todayPrice", "change"})
public class StockResponse {

    private static final long serialVersionUID = 1L;
    private String todayPrice;
    private String change;

    @XmlElement(name = "todayprice")
    public String getTodayPrice() {
        return todayPrice;
    }

    public void setTodayPrice(String todayPrice) {
        this.todayPrice = todayPrice;
    }

    @XmlElement(name = "change")
    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

}
