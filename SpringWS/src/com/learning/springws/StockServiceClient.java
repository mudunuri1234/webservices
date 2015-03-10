package com.learning.springws;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringSource;
import org.springframework.xml.transform.StringResult;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Source;
import javax.xml.transform.Result;
import java.io.StringWriter;


public class StockServiceClient {

    public static void main(String[] args) throws Exception {
        try {
            StockServiceClient client = new StockServiceClient();
            client.invokeService("GLD");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService(String stockSymbol) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                (new String[]{"applicationContext-jaxws-client.xml"});
        WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");

        String requestXML = createInputXML(stockSymbol);
        Source source = new StringSource(requestXML);
        Result result = new StringResult();
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);

        // Printing the response XML on the console.
        System.out.println("---- Response XML is ----" + result.toString());
    }

    private String createInputXML(String stockSymbol) throws Exception {
        //JAXB annotated request object
        StockRequest request = new StockRequest();
        request.setSymbol(stockSymbol);

        // Converting the Java objects into XML to see the request
        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(StockRequest.class);
        Marshaller m = context.createMarshaller();
        m.marshal(request, writer);
        System.out.println("--- Request XML is ---" + writer.toString());

        return writer.toString();
    }

}
