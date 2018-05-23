package academy.dd.artemis.dlq;

import academy.dd.artemis.jolokia.ArtemisJolokiaClient;
import academy.dd.artemis.date.Day;
import org.jolokia.client.exception.J4pException;
import org.junit.Before;
import org.junit.Test;

import javax.management.MalformedObjectNameException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ArtemisDLQTests {

    private ArtemisJolokiaClient artemisJolokiaClient;

    @Before
    public void setup() {
        this.artemisJolokiaClient = new ArtemisJolokiaClient();
    }

    @Test
    public void shouldHaveZeroMessagesOnDeadLetterQueue() throws MalformedObjectNameException, J4pException, IOException {
        Long deadLetterQueueSize = artemisJolokiaClient.getTotalDeadLetterQueueSize();
        artemisJolokiaClient.analyseDeadLetterQueueMessages();
        assertThat("Dead Letter Queue is not empty", deadLetterQueueSize, is(0L));
    }

    @Test
    public void shouldHaveZeroMessagesOnDeadLetterQueueForToday() throws Exception {
        int deadLetterQueueSize = artemisJolokiaClient.getDeadLetterQueueSizeForDate(Day.TODAY);
        artemisJolokiaClient.analyseDeadLetterQueueMessages();
        assertThat("Dead Letter Queue is not empty", deadLetterQueueSize, is(0));
    }

    @Test
    public void shouldHaveZeroMessagesOnDeadLetterQueueForYesterday() throws Exception {
        int deadLetterQueueSize = artemisJolokiaClient.getDeadLetterQueueSizeForDate(Day.YESTERDAY);
        artemisJolokiaClient.analyseDeadLetterQueueMessages();
        assertThat("Dead Letter Queue is not empty", deadLetterQueueSize, is(0));
    }

    @Test
    public void shouldHaveZeroMessagesOnDeadLetterQueueForGivenDate() throws Exception {
        int deadLetterQueueSize = artemisJolokiaClient.getDeadLetterQueueSizeForDate("2018-03-14");
        artemisJolokiaClient.analyseDeadLetterQueueMessages();
        assertThat("Dead Letter Queue is not empty", deadLetterQueueSize, is(0));
    }
}

