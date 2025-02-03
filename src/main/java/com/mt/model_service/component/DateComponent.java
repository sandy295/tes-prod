package com.mt.model_service.component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DateComponent {

    public List<String> getDates(String dateString, int n) {
        List<String> dateList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate inputDate = LocalDate.parse(dateString, formatter);
        for (int i =(int)n/2; i > 1; i--) {
            LocalDate backwardDate = inputDate.minusMonths(i);
            dateList.add(backwardDate.format(formatter));
        }
        dateList.add(dateString);
        for (int i = 1; i <=(int)n/2; i++) {
            LocalDate forwardDate = inputDate.plusMonths(i);
            dateList.add(forwardDate.format(formatter));
        }
        return dateList;
    }
}