package com.example.test2.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    private final static SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
    //din data in string
    public static String fromDate(SimpleDateFormat d){
        if(d==null){
            return null;
        }
        return d.format(FORMATTER);
    }
    //din string in data
    public static Date toDate(String s){
        try {
            return  FORMATTER.parse(s);
        } catch (ParseException e) {
            return null;
        }
    }

}
