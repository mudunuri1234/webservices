package com.learning.ws.jaxp;

import org.w3c.dom.*;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.ArrayList;

public class SimpleDOMParser {

    public static void main(String[] args) {
        try {
            SimpleDOMParser simpleDOMParser = new SimpleDOMParser();
            simpleDOMParser.parseXMLUsingDOM();
            //simpleDOMParser.createXMLUsingDOM();
            //test();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void test() throws Exception {

//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = factory.newDocumentBuilder();
//        Document document = builder.newDocument();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        DOMImplementation domImpl = builder.getDOMImplementation();
        Document document = domImpl.createDocument(null, "students", null);

        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        Source src = new DOMSource(document);
        Result dest = new StreamResult(System.out);
        aTransformer.transform(src, dest);

    }

    public void parseXMLUsingDOM() throws Exception {
        //Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        //Use the factory to create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Parse the XML document
        Document doc = builder.parse(new InputSource("C:/students.xml"));

        //Get the root element
        ArrayList<Student> studentList = new ArrayList<Student>();
        Student student = new Student();
        Node rootElement = doc.getDocumentElement();
        System.out.println("----- Root element name is -----" + rootElement.getNodeName());
        //Get all child nodes of a Root Node
        NodeList nodeList = rootElement.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                String elementName = node.getNodeName();
                System.out.println("---- element name is ---- " + elementName);
                student = new Student();
                if (elementName.equalsIgnoreCase("student")) {
                    NodeList childNodeList = node.getChildNodes();
                    //Looping through all child nodes
                    for (int j = 0; j < childNodeList.getLength(); j++) {
                        Node childNode = childNodeList.item(j);
                        String childNodeName = childNode.getNodeName();
                        String childNodeValue = childNode.getTextContent();
                        //write logic here to get the XML data; poulate data into Java objects.
                        if ("id".equalsIgnoreCase(childNodeName)) {
                            student.setId(childNodeValue);
                        } else if ("firstName".equalsIgnoreCase(childNodeName)) {
                            student.setFirstName(childNodeValue);
                        } else if ("lastName".equalsIgnoreCase(childNodeName)) {
                            student.setLastName(childNodeValue);
                        }
                    }
                    //add each student object to a list
                    studentList.add(student);
                }
            }
        }

        //Priting the student data on console
        for (Student studentObj : studentList) {
            System.out.println(" Id: " + studentObj.getId());
            System.out.println(" firstName: " + studentObj.getFirstName());
            System.out.println(" lastName: " + studentObj.getLastName());
        }
    }

    private void createXMLUsingDOM() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Document document = builder.newDocument();

        DOMImplementation domImpl = builder.getDOMImplementation();
        Document document = domImpl.createDocument(null, "students", null);

        //gets the root element
        Element studentsElement = document.getDocumentElement();

        //append child to root
        Element studentElement = document.createElement("student");
        studentsElement.appendChild(studentElement);

        //append other child elements and set data to it
        Element idElement = document.createElement("id");
        idElement.setTextContent("1");
        studentElement.appendChild(idElement);

        Element firstNameElement = document.createElement("firstName");
        firstNameElement.setTextContent("John");
        studentElement.appendChild(firstNameElement);

        Element lastNameElement = document.createElement("lastName");
        lastNameElement.setTextContent("Smith");
        studentElement.appendChild(lastNameElement);

//       Document document = builder.newDocument();

        //Creates a root element
//        Element rootElement = document.createElement("students");
//        document.appendChild(rootElement);
//
//        Element studentElement = document.createElement("student");
//        document.appendChild(studentElement);
//
//        Element idElement = document.createElement("id");
//        idElement.setTextContent("1");
//        studentElement.appendChild(idElement);
//
//        Element firstNameElement = document.createElement("firstName");
//        idElement.setTextContent("John");
//        studentElement.appendChild(firstNameElement);
//
//        Element lastNameElement = document.createElement("lastName");
//        idElement.setTextContent("Smith");
//        studentElement.appendChild(lastNameElement);

        TransformerFactory tranFactory = TransformerFactory.newInstance();
        Transformer aTransformer = tranFactory.newTransformer();
        Source src = new DOMSource(document);
        Result dest = new StreamResult(System.out);
        aTransformer.transform(src, dest);

    }

    public void createEmptyDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //Creates a new instance of a DOM Document object to build a DOM tree with.
        //It is the root of the document tree
        Document doc = builder.newDocument();
    }

    public void parseXML() throws Exception {
        String myXML = "";
        // Create a DocumentBuilderFactory
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Use the factory to create a DocumentBuilder
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Parse the XML file
        //Document doc = builder.parse("C:/students.xml");
        //Get a list of all elements in the document

        Document doc = builder.parse(new InputSource("C:/students.xml"));
//        Document doc = builder.parse(new InputSource(new ByteArrayInputStream(myXML.getBytes())));
//        URI uri = new URI("http://localhost:8080/wsbook/demo/student.xml");
//        Document doc3 = builder.parse(uri.toString());

        //Get a list of all elements in the document
        NodeList list = doc.getElementsByTagName("*");
        System.out.println("XML Elements: ");
        for (int i = 0; i < list.getLength(); i++) {
            //Prints all elements.
            Element element = (Element) list.item(i);
            System.out.println(element.getNodeName());
        }
    }

}
