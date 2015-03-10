package com.learning.springws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.input.SAXBuilder;
import org.jdom.output.XMLOutputter;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Iterator;


@Endpoint
public class HolidayServiceEndpoint {

    @PayloadRoot(namespace = "http://springws.ws.learning.com/holidays/schemas",
                 localPart = "getHolidayRequest")
    @ResponsePayload
    public Element getEmployee(@RequestPayload Element holidayRequest) throws Exception {
        //Converting the JDOM element to a java String
        XMLOutputter outputter = new XMLOutputter();
        String inputRequest = outputter.outputString(holidayRequest);
        System.out.println("-------- inputRequest  ---------- " + inputRequest);

        //Private method used to parse the XML to get the year
        String year = getYear(inputRequest);

        //Private method used to build the response XML
        Element holidayResponse = buildHolidaysResponse(year);

        return holidayResponse;
    }

    private static String getYear(String inputRequest) throws Exception {
        InputStream is = new ByteArrayInputStream(inputRequest.getBytes("UTF-8"));
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(is);
        Element root = document.getRootElement();
        List children = root.getChildren();
        Iterator iterator = children.iterator();
        String year = "";
        while (iterator.hasNext()) {
            Element child = (Element) iterator.next();
            year = child.getValue();
        }

        System.out.println("-------- year  ---------- " + year);
        return year;
    }

    private static Element buildHolidaysResponse(String year) throws Exception {
        Element responseElement = new Element("getHolidayResponse",
                "http://springws.ws.learning.com/holidays/schemas");
        Document myDocument = new Document(responseElement);
        Element holidaysElement = new Element("holidays").setAttribute("year", year);
        responseElement.addContent(holidaysElement);

        Element janElement1 = new Element("January").setText("02-jan-2012");
        holidaysElement.addContent(janElement1);

        Element janElement2 = new Element("January").setText("16-jan-2012");
        holidaysElement.addContent(janElement2);

        Element febElement = new Element("February").setText("20-feb-2012");
        holidaysElement.addContent(febElement);

        Element mayElement = new Element("May").setText("28-may-2012");
        holidaysElement.addContent(mayElement);

        Element julyElement = new Element("July").setText("04-july-2012");
        holidaysElement.addContent(julyElement);

        Element septElement = new Element("September").setText("03-sept-2012");
        holidaysElement.addContent(septElement);

        Element octElement = new Element("October").setText("08-oct-2012");
        holidaysElement.addContent(octElement);

        Element novElement1 = new Element("November").setText("12-nov-2012");
        holidaysElement.addContent(novElement1);

        Element novElement2 = new Element("November").setText("22-nov-2012");
        holidaysElement.addContent(novElement2);

        Element decElement = new Element("December").setText("25-dec-2012");
        holidaysElement.addContent(decElement);

        XMLOutputter outputter = new XMLOutputter();
        outputter.output(myDocument, System.out);

        return responseElement;
    }

}
