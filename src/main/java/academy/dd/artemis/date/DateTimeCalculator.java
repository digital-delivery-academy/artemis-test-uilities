package academy.dd.artemis.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeCalculator {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private final Calendar calendar = Calendar.getInstance();
    private Day day;

    private String calculatedDate;

    public DateTimeCalculator(Day day) throws Exception {
        this.day = day;
        calculateFromGivenDay();
    }

    public DateTimeCalculator(String date) throws ParseException {
        this.calculatedDate = dateFormat.format(dateFormat.parse(date));
    }

    public String getDate() {
        return this.calculatedDate;
    }

    private void calculateFromGivenDay() throws Exception {
        switch(day) {
            case TODAY:
                this.calculatedDate = dateFormat.format(calendar.getTime());
                break;

            case YESTERDAY:
                calendar.add(Calendar.DATE, -1);
                this.calculatedDate = dateFormat.format(calendar.getTime());
                break;

            default:
                throw new Exception("Cannot calculate the date, must be one of TODAY or YESTERDAY");
        }
    }
}
