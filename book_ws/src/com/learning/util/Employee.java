package com.learning.util;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import java.util.ArrayList;

@XmlRootElement(name="employee")
//Controls the ordering of fields and properties in a class. 
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class Employee {

    private static final long serialVersionUID = 1L;
    private String employeeId;
    private String lastName;
    private String firstName;
    private Address address;

    /* holds the list of employee addresses */
    private Collection<Address> addressList = new ArrayList<Address>();

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }    

    @XmlElement(name="address")
    @XmlElementWrapper(name="homeAddress")
    public Collection<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(Collection<Address> addressList) {
        this.addressList = addressList;
    }

}
