package com.learning.ws.jaxp;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.XMLReader;
import org.xml.sax.SAXException;
import org.xml.sax.Locator;
import org.xml.sax.Attributes;

public class SimpleSAXParser extends DefaultHandler {

    private StringBuilder currentTagContent = new StringBuilder();
    private Locator locator;

    public static void main(String[] args) {
        try {
            DefaultHandler xmlHandler = new SimpleSAXParser();
            XMLReader xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(xmlHandler);
            //set the error handler
            xmlReader.setErrorHandler(new SAXErrorHandler());
            //use any valid XML
            xmlReader.parse("C:/students.xml");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    public void characters(char[] ch, int start, int length) throws SAXException {
//        System.out.println("------ element content -----" +
//                currentTagContent.append(new String(ch, start, length)));
//    }

//    public void startElement(String uri, String localName, String qName, Attributes attr) {
//        System.out.println("---- uri ---" + uri + "-- localName --" + localName + "---- qName ----" + qName);
//        System.out.println("---- qName ----" + qName);
//        for (int i = 0; i < attr.getLength(); i++) {
//            System.out.println("---- attribute value is ---" + attr.getValue(i));
//        }
//    }

   public void startPrefixMapping (String prefix, String uri) {
        System.out.println("--- prefix ---" + prefix + "--- uri ---" + uri);
   }

//    public void endPrefixMapping(String prefix) throws SAXException {
//        System.out.println("------- end prefix ------" + prefix);
//    }

//    public void endElement(String uri, String localName, String qName) {
//        System.out.println("------- qName ------" + qName);
//    }
//
//    public void processingInstruction(String target, String data) throws SAXException {
//        System.out.println("------- data ------" + data);
//    }
//
//    public void setDocumentLocator(Locator locator) {
//        this.locator = locator;
//        if (locator != null) {
//            int col = locator.getColumnNumber();
//            int line = locator.getLineNumber();
//            String publicId = locator.getPublicId();
//            String systemId = locator.getSystemId();
//            System.out.println("-- col --" + col + "-- line --" + line +
//                    "-- publicId --" + publicId + "-- systemId --" + systemId);
//        }
//    }
//
//    public void skippedEntity(String name) {
//        System.out.println("-" + locator.getLineNumber() + "---Skipped Entity");
//        System.out.println("           Name: " + name);
//    }
//
//    public void startDocument() throws SAXException {
//    }

}
