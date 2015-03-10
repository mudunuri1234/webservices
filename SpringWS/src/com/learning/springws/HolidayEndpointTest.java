package com.learning.springws;

import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Calendar;

import org.jdom.Document;
import org.jdom.input.SAXBuilder;

public class HolidayEndpointTest {

    private Document holidayRequest;

    private HolidayEndpoint endpoint;

    private HumanResourceService serviceMock;

    private Calendar startCalendar;

    private Calendar endCalendar;

    public static void main(String args[]) {
        try {
            HolidayEndpointTest test = new HolidayEndpointTest();
            test.setUp();
            test.handleHolidayRequest();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setUp() throws Exception {
        HumanResourceService serviceMock = new StubHumanResourceService();
        SAXBuilder builder = new SAXBuilder();
        InputStream is = new FileInputStream("C:/projects/Learning/SpringWS/conf/springws/holidayRequest.xml");
        try {
            holidayRequest = builder.build(is);
        }
        finally {
            is.close();
        }
        endpoint = new HolidayEndpoint(serviceMock);
        startCalendar = Calendar.getInstance();
        startCalendar.clear();
        startCalendar.set(2006, Calendar.JULY, 3);
        endCalendar = Calendar.getInstance();
        endCalendar.clear();
        endCalendar.set(2006, Calendar.JULY, 7);
    }

    public void handleHolidayRequest() throws Exception {
        HumanResourceService serviceMock = new StubHumanResourceService();
        serviceMock.bookHoliday(startCalendar.getTime(), endCalendar.getTime(), "John Doe");
        //replay(serviceMock);

        endpoint.handleHolidayRequest(holidayRequest.getRootElement());
        //verify(serviceMock);
    }


}
