package com.sirh.demo.utilities;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.tuple.Pair;

public class MongoDate {
    public Pair<Date, Date> getStartAndEndOfDay(Date inputDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(inputDate);
    
        // Début de la journée (00:00:00)
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date startDate = calendar.getTime();
    
        // Fin de la journée (23:59:59)
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MILLISECOND, -1);
        Date endDate = calendar.getTime();
    
        return Pair.of(startDate, endDate);
    }
}
