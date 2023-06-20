package appmanager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeStampHelper extends HelperBase {

    public String getTimeStamp(String pattern) {
        String timeStamp = new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public String getTimeStampWithAddSomeAmountOfDays(String pattern, int amountOfDays) throws ParseException {
        String curentDate = getTimeStamp(pattern);
        String dt = curentDate;  // Start date
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.DATE, amountOfDays);  // number of days to add
        dt = sdf.format(c.getTime());  // dt is now the new date
        return dt;
    }

    public String getTimeStampWithAddSomeAmountOfMonth(String pattern, int amountOfMonth) throws ParseException {
        String curentDate = getTimeStamp(pattern);
        String dt = curentDate;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c = Calendar.getInstance();
        c.setTime(sdf.parse(dt));
        c.add(Calendar.MONTH, amountOfMonth);
        dt = sdf.format(c.getTime());
        return dt;
    }
}