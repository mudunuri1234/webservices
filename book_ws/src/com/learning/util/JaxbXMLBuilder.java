package com.learning.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class JaxbXMLBuilder {

   public static void main(String args[]) {
        try {
            JaxbXMLBuilder builder = new JaxbXMLBuilder();
            builder.generateXML();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
   }

   private void generateXML() throws Exception {
       /* holds the list of employee employees */
       Collection<Employee> empList = new ArrayList<Employee>();
       /* holds the list of employee addresses */
       Collection<Address> addressList = new ArrayList<Address>();
       /* holds the entire dara structure */
       EmployeeCollection coll = new EmployeeCollection();

       Employee employee = new Employee();
       Address address = new Address();
       employee.setEmployeeId("1");
       employee.setFirstName("John");
       employee.setLastName("McCoy");

       address = new Address();
       address.setCity("Chandler");
       address.setStreet("Roundabout cir");
       address.setZip("85226");
       address.setCountry("USA");
       addressList = new ArrayList<Address>();
       addressList.add(address);
       employee.setAddressList(addressList);
       empList.add(employee);

       employee = new Employee();
       employee.setEmployeeId("2");
       employee.setFirstName("John");
       employee.setLastName("Smith");
       empList.add(employee);

       address = new Address();
       address.setCity("Reading");
       address.setStreet("Malting Place");
       address.setZip("RG67QG");
       address.setCountry("UK");
       addressList = new ArrayList<Address>();
       addressList.add(address);
       employee.setAddressList(addressList);

       coll.setEmpList(empList);

       /* Generates XML representation of an individual*/
       StringWriter writer = new StringWriter();
       JAXBContext context = JAXBContext.newInstance(EmployeeCollection.class);
       Marshaller m = context.createMarshaller();
       m.marshal(coll, writer);
       System.out.println(writer);
   }

}
