package com.learning.ws.jaxp;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;

public class TestErrorHandler {

    public static void main(String[] args) {
        try {
            TestErrorHandler example = new TestErrorHandler();
            example.parseXML();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void parseXML() throws Exception {
        try {
            DefaultHandler xmlHandler = new SimpleSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(xmlHandler);
            xmlReader.setErrorHandler(new SAXErrorHandler());
            xmlReader.parse("C:/students.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error Parsing Result", ex);
        }
    }

}
