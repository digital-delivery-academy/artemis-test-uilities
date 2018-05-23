package academy.dd.artemis.date;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DateTimeCalculatorTests {

    @Test
    public void shouldConvertDayToFormattedDateForToday() throws Exception {
        DateTimeCalculator dateTimeCalculator = new DateTimeCalculator(Day.TODAY);
        assertThat("Date isn't correct or is formatted incorrectly", dateTimeCalculator.getDate(), is("2018-01-22"));
    }

    @Test
    public void shouldConvertDayToFormattedDateForYesterday() throws Exception {
        DateTimeCalculator dateTimeCalculator = new DateTimeCalculator(Day.YESTERDAY);
        assertThat("Date isn't correct or is formatted incorrectly", dateTimeCalculator.getDate(), is("2018-01-21"));
    }

    @Test
    public void shouldConvertDayToFormattedDateForGivenDate() throws Exception {
        DateTimeCalculator dateTimeCalculator = new DateTimeCalculator("2018-01-21");
        assertThat("Date isn't correct or is formatted incorrectly", dateTimeCalculator.getDate(), is("2018-01-21"));
    }

}
