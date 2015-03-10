package com.learning.ws.jaxp;

import org.dom4j.io.SAXReader;
import org.dom4j.io.DOMReader;
import org.dom4j.io.XMLWriter;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.DocumentHelper;
import org.dom4j.tree.DefaultDocument;
import org.dom4j.util.NodeComparator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class Dom4JExample {

    public static void main(String[] args) {
        try {
            Dom4JExample dom4j = new Dom4JExample();
            //dom4j.compareXMLDocuments();
            //dom4j.dom4jXPathTest();
            dom4j.createXMLUsingDom4j();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Document parseXMLUsingSAX() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\students.xml"));
        String xmlAsString = document.asXML();
        System.out.println(xmlAsString);
        return document;
    }
        
    public Document parseXMLUsingDOM() throws Exception {
        DOMReader reader = new DOMReader();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        org.w3c.dom.Document w3cDOMDocument = builder.parse(new File("C:\\students.xml"));

        //Converts the w3c DOM document to dom4j Document.
        org.dom4j.Document document = reader.read(w3cDOMDocument);

        //Printing the XML document as String
        String xmlAsString = document.asXML();
        System.out.println(xmlAsString);
        return document;
    }

    public void loadAndParseXML() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\students.xml"));
        Element root = document.getRootElement();

        Student student = null;
        List<Student> studentList = new ArrayList<Student>();
        for(Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            if("Student".equalsIgnoreCase(element.getName())) {
                student = new Student();
            }

            for(int j = 0, size = element.nodeCount(); j < size; j++ ) {
                Node node = (Node) element.node(j);
                if(node instanceof Element) {
                    if("id".equalsIgnoreCase(node.getName())) {
                        student.setId(node.getText());
                    }
                    if("firstName".equalsIgnoreCase(node.getName())) {
                        student.setFirstName(node.getText());
                    }
                    if("lastName".equalsIgnoreCase(node.getName())) {
                        student.setLastName(node.getText());
                    }
                }
            }
            studentList.add(student);
        }

        //Priting the student data on console
        for(Student studentObj : studentList) {
            System.out.println(" Id: " + studentObj.getId());
            System.out.println(" firstName: " + studentObj.getFirstName());
            System.out.println(" lastName: " + studentObj.getLastName());
        }
    }

    public void dom4jXPathTest() throws Exception {
        //jar files added - jaxen-1.1-beta-6.jar
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("C:\\students.xml"));
        List list = document.selectNodes("//Students");
        for(int i=0; i<list.size(); i++) {
            Node node = (Node) list.get(i);
            System.out.println("------ nodes ----" + node.getName());
        }

        System.out.println("------ list ----" + list.size());
        Node node = document.selectSingleNode("//Students/Student");
        String name = node.valueOf("lastName");
        System.out.println("------ name ----" + name);        
    }

    public void createXMLUsingDom4j() throws Exception {
        Document document = DocumentHelper.createDocument();
        Element rootElement = document.addElement("students");
        Element studentElement = rootElement.addElement("Student");
        studentElement.addElement("id").addAttribute("country", "usa").addText("1");
        studentElement.addElement("firstName").addText("John");
        studentElement.addElement("lastName").addText("Smith");

        //Convert document to XML and print on console
        String xmlString = document.asXML();
        System.out.println(xmlString);

        //Convert from String to XML
        Document documentFromXML = DocumentHelper.parseText(xmlString);

        //Print the document to output.xml file
        XMLWriter writer = new XMLWriter(new FileWriter("c:\\output.xml") );
        writer.write( document );
        writer.close();


//        Document doc = new DefaultDocument();
//        doc.addElement("Students");
//        Element rootElement1 = doc.getRootElement();
    }

    public void compareXMLDocuments() throws Exception {
        SAXReader reader = new SAXReader();
        Document document1 = reader.read(new File("C:\\students.xml"));
        Document document2 = reader.read(new File("C:\\students1.xml"));

        NodeComparator comparator = new NodeComparator();
        if(comparator.compare(document1, document2) == 0) {
            System.out.println("Both documents are same.");
        } else {
            System.out.println("Both documents are different.");
        }
    }

}


