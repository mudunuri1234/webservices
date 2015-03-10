package com.learning.util;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="address")
@XmlType(propOrder = {"street", "city", "zip"})
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType
public class Address {

    private String street;
    private String city;
    private String zip;
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //Used for renaming the element.
    @XmlElement(name = "zipCode", nillable=true, required=true)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @XmlAttribute(name="country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
