package utils;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class MyDate {
    
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");;

    public MyDate() { }
    
    public static String getDate(JDateChooser datepicker) {
        if(datepicker.getDate() != null)
            return sdf.format(datepicker.getDate());
        else 
            return null;
    }
    
    public static Date Str2Date(String pDate) {
        Date date = null;
        try {
            date = sdf.parse(pDate);
            return date;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error trying to convert date to string", "Message", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }
}