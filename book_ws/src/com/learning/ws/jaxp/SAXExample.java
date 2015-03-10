package com.learning.ws.jaxp;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;

public class SAXExample {

     public static void main(String[] args) {
        try {
              SAXExample example = new SAXExample();
              example.parseXML();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
     }

    private void parseXML() throws Exception {
        try {
            DefaultHandler xmlHandler = new SimpleSAXParser();
            XMLReader xmlReader1 = XMLReaderFactory.createXMLReader();
            xmlReader1.setContentHandler(xmlHandler);
            xmlReader1.parse("C:/students.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error Parsing Result", ex);
        }
    }
}
