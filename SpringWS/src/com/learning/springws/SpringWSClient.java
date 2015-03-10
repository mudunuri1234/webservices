package com.learning.springws;

import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.xml.transform.StringSource;
import org.springframework.xml.transform.StringResult;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import javax.xml.transform.Source;
import javax.xml.transform.Result;

public class SpringWSClient {

    public static void main(String args[]) {
        try {
            SpringWSClient client = new SpringWSClient();
            client.invokeService("6666666");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void invokeService(String employeeId) throws Exception {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext(new String[]{"applicationContext-client.xml"});
        WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");

//        ClientLogMessageHandler[] handler = new ClientLogMessageHandler[1];
//        handler[0] = new ClientLogMessageHandler();
//        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
//        webServiceTemplate.setDefaultUri("http://localhost:8080/springws/services/employeeService/");
//        webServiceTemplate.setInterceptors(handler);
//        System.out.println("------- webServiceTemplate ----------" + webServiceTemplate.getDefaultUri());

        String requestXML = createInputXML(employeeId);
        Source source = new StringSource(requestXML);
        Result result = new StringResult();
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);

        //Object result1 = webServiceTemplate.marshalSendAndReceive(source);
        System.out.println("--------- result --------" + result.toString());
    }

    private String createInputXML(String employeeId) throws Exception {
        Document document = DocumentHelper.createDocument();
        Element requestElement = document.addElement("getEmployeeRequest ", "http://springws.ws.learning.com/emp/schemas");
        Element employeeElement = requestElement.addElement("employee");
        employeeElement.addElement("employeeId").addText(employeeId);
        //converting input XML to a String
        System.out.println("-------- String  ---------- " + document.asXML());
        return document.asXML();
    }

}
