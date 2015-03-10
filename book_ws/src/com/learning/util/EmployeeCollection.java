package com.learning.util;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Collection;
import java.util.ArrayList;

@XmlRootElement(name="employees")
public class EmployeeCollection {

    private Collection<Employee> empList = new ArrayList<Employee>();

    @XmlElement(name="employee", type=Employee.class)
    public Collection<Employee> getEmpList() {
        return empList;
    }

    public void setEmpList(Collection<Employee> empList) {
        this.empList = empList;
    }

}
