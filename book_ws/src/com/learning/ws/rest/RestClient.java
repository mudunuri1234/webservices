package com.learning.ws.rest;

import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.apache.cxf.jaxrs.client.WebClient;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.Response;
import java.net.URL;
import java.net.URLConnection;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;
import java.awt.print.Book;

/**
 * Created by IntelliJ IDEA.
 * User: asmudun
 * Date: Nov 22, 2011
 * Time: 11:23:01 AM
 */
public class RestClient {

    public static void main(String args[]) {
        try {
            RestClient rc = new RestClient();
            rc.testInheritance();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void testInheritance() throws Exception {
          RestTemplate restTemplate = new RestTemplate();
          String result = restTemplate.getForObject("http://localhost:8080/wsbook/services/stockservice/symbol/{symbol}", String.class, "GLD");
          System.out.println("result: " + result);
    }


    public void testClient1() throws Exception {

//        GradeManager store = JAXRSClientFactory.create("http://localhost:8080/wsbook/services/gradeservice/grades", GradeManager.class);
//        // (1) remote GET call to http://bookstore.com/bookstore
//        String books = store.getGrades();
//        System.out.println( books );

        WebClient wc = WebClient.create("http://localhost:8080/wsbook/services/gradeservice/grades");
        Response getresponse = wc.path("/grades").get();

        System.out.println(getresponse);

    }

    private static void testClient2() throws Exception {
        String url1 = "http://localhost:8080/wsbook/services/gradeservice/grades";

        URL url = new URL(url1);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);

        InputStreamReader isr=new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String response;
        while((response = br.readLine()) != null ) {
            System.out.println( response );
        }
        br.close();
    }

    private static void testClient3() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("http://localhost:8080/wsbook/services/gradeservice/grade/{grade}", String.class, "1");
        System.out.println("result: " + result);

        Map<String, String> vars = new HashMap<String, String>();
        vars.put("grade", "1");
        vars.put("subject", "Java");

        String result1 = restTemplate.getForObject("http://localhost:8080/wsbook/services/gradeservice/grade/{grade}/subject/{subject}",
                String.class, vars);
        System.out.println("result1: " + result1);

        Map<String, String> topics = new HashMap<String, String>();
        vars.put("grade", "1");
        vars.put("subject", "Math");
        vars.put("topic", "Mathematics and art");

        String result2 = restTemplate.getForObject("http://localhost:8080/wsbook/services/gradeservice/grade/1/subject/{subject}/topic/{topic}",
                String.class, vars);
        System.out.println("result2: " + result2);
    }


     private static void test() throws Exception {
        String url1 = "http://localhost:8080/wsbook/services/stockservice/symbol?symbol=null";

        URL url = new URL(url1);
        URLConnection conn = url.openConnection();
        conn.setDoOutput(true);

        InputStreamReader isr=new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(isr);

        String response;
        while((response = br.readLine()) != null ) {
            System.out.println( response );
        }
        br.close();
    }


    private static void test4() throws Exception {
          RestTemplate restTemplate = new RestTemplate();
          String result = restTemplate.getForObject("http://localhost:8080/wsbook/services/document/delete/{id}", String.class, "1");
          System.out.println("result: " + result);
    }

}
