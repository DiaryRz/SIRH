package com.sirh.demo.utilities;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.Date;
import java.util.TimeZone;

public class ConvertDate {

    public Date convertStringToDateTime(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); 
        return dateFormat.parse(dateString);
    }
    
    public Date convertStringToDate(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC")); 
        return dateFormat.parse(dateString);
    }
}
