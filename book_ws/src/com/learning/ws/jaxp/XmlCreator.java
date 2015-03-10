package com.learning.ws.jaxp;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.tree.DefaultDocument;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.InputSource;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.ByteArrayInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: Srinivas
 * Date: Nov 1, 2008
 * Time: 10:23:20 AM
 */
public class XmlCreator {

    public static void main(String[] args) {
        try {

            //for creating xml : single
            XmlCreator xmlCreator = new XmlCreator();
            String xml = xmlCreator.getStudentXml();
            System.out.println(xml);

            //for creating xml : multiple
            List<Student> studentList = xmlCreator.getStudentList();
            String studentsXml = xmlCreator.getAllStudentXml(studentList);
            System.out.println(studentsXml);

//        File f = new File("C:\\test.xml");
//        FileWriter fw = new FileWriter(f);
//        fw.write(studentsXml);
//        fw.close();

            //for reading xml
            List<Student> studentsList = xmlCreator.getStudentData(studentsXml);
            for (Student student : studentsList) {
                System.out.println(" Id: " + student.getId());
                System.out.println(" firstName: " + student.getFirstName());
                System.out.println(" lastName: " + student.getLastName());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //for creating xml : multiple
    private List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<Student>();
        Student student = new Student();
        student.setId("1");
        student.setFirstName("Srinivas");
        student.setLastName("P");
        studentList.add(student);

        student = new Student();
        student.setId("2");
        student.setFirstName("Madhav");
        student.setLastName("V");
        studentList.add(student);

        student = new Student();
        student.setId("3");
        student.setFirstName("Lakshmi");
        student.setLastName("K");
        studentList.add(student);
        return studentList;
    }

    //for creating xml: single
    public String getStudentXml() {
        Document doc = new DefaultDocument();
        doc.addElement("Students");
        Element rootElement = doc.getRootElement();

        Element studentElement = rootElement.addElement("Student");

        Element idElement = studentElement.addElement("id");
        idElement.addText("1");

        Element firstNameElement = studentElement.addElement("firstName");
        firstNameElement.addText("Srinivas");

        Element lastNameElement = studentElement.addElement("lastName");
        lastNameElement.addText("Puppalla");

        String xml = doc.asXML();
        return xml;
    }

    //for creating xml : multiple
    public String getAllStudentXml(List<Student> studentList) {
        Document doc = new DefaultDocument();
        doc.addElement("Students");
        Element rootElement = doc.getRootElement();

        for (Student student : studentList) {
            Element studentElement = rootElement.addElement("Student");
            Element idElement = studentElement.addElement("id");
            idElement.addText(student.getId());

            Element firstNameElement = studentElement.addElement("firstName");
            firstNameElement.addText(student.getFirstName());

            Element lastNameElement = studentElement.addElement("lastName");
            lastNameElement.addText(student.getLastName());
        }

        String xml = doc.asXML();
        return xml;
    }

    //for reading xml
    private List<Student> getStudentData(String studentXML) throws Exception {
        //Parse the output xml to get the result
        StudentInfoXmlSchemaParser studentOutputParser = new StudentInfoXmlSchemaParser();
        parseOutputXML(studentXML, studentOutputParser);
        List<Student> studentsList1 = studentOutputParser.studentsList;
        return studentsList1;
    }

    //for reading xml
    private class StudentInfoXmlSchemaParser extends AbstractXmlSchemaParser {
        List<Student> studentsList = new ArrayList<Student>();
        Student student = null;

        protected void startTag(String name) {
            if ("student".equalsIgnoreCase(name)) {
                student = new Student();
                studentsList.add(student);
            }
        }

        protected void endTag(String name, String tagContent) {
            if (tagContent != null) {
                if ("id".equalsIgnoreCase(name)) {
                    student.setId(tagContent);
                } else if ("firstName".equalsIgnoreCase(name)) {
                    student.setFirstName(tagContent);
                } else if ("lastName".equalsIgnoreCase(name)) {
                    student.setLastName(tagContent);
                }
            }
        }
    }

    //for reading xml
    private void parseOutputXML(String ouptData, DefaultHandler xmlHandler) throws Exception {
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        parserFactory.setValidating(false);
        parserFactory.setNamespaceAware(false);
        try {           
            SAXParser saxParser = parserFactory.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(xmlHandler);
            xmlReader.parse("C:/students.xml");

            xmlReader.parse(new InputSource(new ByteArrayInputStream(ouptData.getBytes())));

            xmlReader.parse(new InputSource("C:/students.xml"));

            XMLReader xmlReader1 = XMLReaderFactory.createXMLReader();
            xmlReader1.setContentHandler(xmlHandler);
            xmlReader1.parse("C:/students.xml");
            
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("ErrorParsing Result", ex);
        }
    }

}
