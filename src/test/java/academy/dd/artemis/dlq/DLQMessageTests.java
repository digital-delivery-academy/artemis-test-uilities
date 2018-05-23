package academy.dd.artemis.dlq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DLQMessageTests {

    private InputStream dlqMessageInputStream;

    @Before
    public void setup() {
        this.dlqMessageInputStream = ClassLoader.getSystemResourceAsStream("fixtures/sample-dlq-message.json");
    }

    @Test
    public void shouldDeserializeDeadLetterQueueMessageToObject() throws IOException {
        DLQMessage dlqMessage = new ObjectMapper().readValue(dlqMessageInputStream, DLQMessage.class);
        assertThat("Fields not set after deserialization of sample DLQ message",
                dlqMessage.getJMSType(),
                is("Message"));
    }
}