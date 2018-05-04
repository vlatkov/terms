package com.terms.config;

import org.joda.time.DateTime;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class FormatDate {

    public static Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());

    }
    static DateTime formaterDate(Date date, String format){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy HH:mm:ss S");
        DateTime dt = new DateTime();
        dt.toDateTime();
        return dt;
    }

}
