package com.learning.ws.jaxp;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public abstract class AbstractXmlSchemaParser extends DefaultHandler {
    private StringBuilder currentTagContent = new StringBuilder();
    private boolean nil;

    public void characters(char[] ch, int start, int length) throws SAXException {
        currentTagContent.append(new String(ch, start, length));
    }

    public void startElement(String uri, String localName, String qName, Attributes attr) {
        // detect nil tags
        nil = Boolean.parseBoolean(attr.getValue("xsi:nil"));
        startTag(qName);
    }

    public void endElement(String uri, String localName, String qName) {
        String currentTag = currentTagContent.toString().trim();
        currentTagContent.setLength(0);
        if (nil) {
            nil = false;
        } else {
            // leave field in DTO set to null
            endTag(qName, currentTag);
        }
    }

    protected abstract void startTag(String name);

    protected abstract void endTag(String name, String tagContent);
}
