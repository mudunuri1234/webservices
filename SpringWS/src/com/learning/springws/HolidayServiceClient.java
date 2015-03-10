package com.learning.springws;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;
import org.springframework.xml.transform.StringResult;
import org.jdom.Element;
import org.jdom.Document;
import org.jdom.output.XMLOutputter;

import javax.xml.transform.Source;
import javax.xml.transform.Result;

//http://www.cs.unc.edu/Courses/jbs/lessons/ws/ws_jdom/
public class HolidayServiceClient {

    public static void main(String[] args) throws Exception {
        try {
            HolidayServiceClient client = new HolidayServiceClient();            
            client.invokeService("2000");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService(String year) throws Exception {
        ClientLogMessageHandler[] handler = new ClientLogMessageHandler[1];
        handler[0] = new ClientLogMessageHandler();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("http://localhost:8080/springws/services/holidayService/");
        System.out.println("------- webServiceTemplate ----------" + webServiceTemplate.getDefaultUri());

        String requestXML = createRequestXML(year);
        Source source = new StringSource(requestXML);
        Result result = new StringResult();
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);

        System.out.println("--------- result --------" + result.toString());
    }

    private static String createRequestXML(String year) throws Exception {
        Element requestElement = new Element("getHolidayRequest",
                "http://springws.ws.learning.com/holidays/schemas");
        Document myDocument = new Document(requestElement);
        Element yearElement = new Element("year");
        yearElement.setText(year);
        requestElement.addContent(yearElement);

        XMLOutputter outputter = new XMLOutputter();
//        outputter.output(myDocument, System.out);
        String input = outputter.outputString(myDocument);
        System.out.println("-------- input  ---------- " + input);

        return input;
    }

}