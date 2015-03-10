package com.learning.springws;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class StubHumanResourceService implements HumanResourceService {

    public void bookHoliday(Date startDate, Date endDate, String name) {
        System.out.println("---- Booking holiday for [" + startDate + "-" + endDate + "] for [" + name + "] ");
    }
}
