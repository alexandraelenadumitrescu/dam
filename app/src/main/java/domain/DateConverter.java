package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConverter {
    private final static SimpleDateFormat FORMATTER=new SimpleDateFormat("dd-MM-yyyy",Locale.US);
    public static Date toDate(String val){
        try {
            return FORMATTER.parse(val);
        } catch (ParseException e) {
            //throw new RuntimeException(e);
            return null;
        }
    }
    public static String fromDate(Date date){
        if(date==null){
            return null;
        }
        return FORMATTER.format(date);
    }
}
