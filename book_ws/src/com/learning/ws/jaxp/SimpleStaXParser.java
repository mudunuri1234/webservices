package com.learning.ws.jaxp;

import javax.xml.stream.*;
import javax.xml.stream.events.*;

import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileWriter;

public class SimpleStaXParser {

    public static void main(String[] args) {
        try {
            SimpleStaXParser simpleStaXParser = new SimpleStaXParser();
            List<Student> studentList = simpleStaXParser.getStudentData();
            //Priting the student data on console
            for (Student studentObj : studentList) {
                System.out.println(" Id: " + studentObj.getId());
                System.out.println(" firstName: " + studentObj.getFirstName());
                System.out.println(" lastName: " + studentObj.getLastName());
            }
            simpleStaXParser.buidXMLUsingStax();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public List<Student> getStudentData() throws Exception {
        // First create a new XMLInputFactory
        XMLInputFactory factory = XMLInputFactory.newInstance();

        // Setup a new eventReader
        XMLEventReader eventReader = factory.createXMLEventReader(new FileInputStream("C:/students.xml"));
        Student student = null;
        List<Student> studentsList = new ArrayList<Student>();

        while (eventReader.hasNext()) {
            //Used to get the various types of StAX events.
            XMLEvent event = eventReader.nextEvent();
            if (event.getEventType() == XMLEvent.START_ELEMENT) {
                StartElement startElement = event.asStartElement();

                //If it is a student element we create a student object to set the data
                if (startElement.getName().getLocalPart().equalsIgnoreCase("student")) {
                    student = new Student();
                }

                //get data from id element
                if (startElement.getName().getLocalPart().equals("id")) {
                    event = eventReader.nextEvent();
                    student.setId(event.asCharacters().getData());
                    continue;
                }

                //get data from first name element
                if (event.asStartElement().getName().getLocalPart().equals("firstName")) {
                    event = eventReader.nextEvent();
                    student.setFirstName(event.asCharacters().getData());
                    continue;
                }

                //get data from last name element
                if (event.asStartElement().getName().getLocalPart().equals("lastName")) {
                    event = eventReader.nextEvent();
                    student.setLastName(event.asCharacters().getData());
                    continue;
                }
            }

            //If we reach the end of stuudent element,add it to the list.
            if(event.getEventType() == XMLEvent.END_ELEMENT) {
                EndElement endElement = event.asEndElement();
                if (endElement.getName().getLocalPart().equalsIgnoreCase("student")) {
                    studentsList.add(student);
                }
            }
        }
        return studentsList;
    }

    private void buidXMLUsingStax() throws Exception {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLEventFactory xmlEventFactory = XMLEventFactory.newInstance();

        XMLEventWriter writer = factory.createXMLEventWriter(new FileWriter("C:\\output.xml"));
        StartDocument startDocument = xmlEventFactory.createStartDocument("UTF-8", "1.0");
        writer.add(startDocument);

        //Creates a root element
        StartElement rootElement = xmlEventFactory.createStartElement("", "", "students");
        writer.add(rootElement);

        //Creates an immediate child to root element
        StartElement startElement = xmlEventFactory.createStartElement("", "", "student");
        writer.add(startElement);

        //creates an id element
        StartElement idStartElement = xmlEventFactory.createStartElement("", "", "id");
        writer.add(idStartElement);
        Characters id = xmlEventFactory.createCharacters("1");
        writer.add(id);
        EndElement idEndElement = xmlEventFactory.createEndElement("", "", "id");
        writer.add(idEndElement);

        //creates an first name element
        StartElement firstNameStartElement = xmlEventFactory.createStartElement("", "", "firstName");
        writer.add(firstNameStartElement);
        Characters firstName = xmlEventFactory.createCharacters("John");
        writer.add(firstName);
        EndElement firstNameEndElement = xmlEventFactory.createEndElement("", "", "firstName");
        writer.add(firstNameEndElement);

        //creates an last name element
        StartElement lastNameStartElement = xmlEventFactory.createStartElement("", "", "lasstName");
        writer.add(lastNameStartElement);
        Characters lastName = xmlEventFactory.createCharacters("Smith");
        writer.add(lastName);
        EndElement lastNameEndElement = xmlEventFactory.createEndElement("", "", "lasstName");
        writer.add(lastNameEndElement);

        writer.flush();
        writer.close();
    }

}