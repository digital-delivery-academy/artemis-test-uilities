package academy.dd.artemis.dlq;

import academy.dd.artemis.jolokia.ArtemisJolokiaClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.jolokia.client.exception.J4pException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import javax.management.MalformedObjectNameException;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class ArtemisJolokiaClientTests {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(4444);

    /**
     * What could go wrong?
     *  - what happens if connection is not established
     *  - what happens if connection is lost halfway through?
     *  - what happens if connection is successful?
     *  - what happens if the cast fails in getTotalDeadLetterQueueSize()?
     *  - what happens if
     */

    private ArtemisJolokiaClient artemisJolokiaClient;

    @Before
    public void setup() throws MalformedObjectNameException, J4pException, IOException {
        String s = new ObjectMapper().readValue(
                ClassLoader.getSystemResourceAsStream("fixtures/sample-dlq-message.json"), String.class);


        artemisJolokiaClient = new ArtemisJolokiaClient();
        wireMockRule.stubFor(get(urlEqualTo("http://localhost:4444/jolokia/exec/org.apache.activemq.artemis:type=Broker,brokerName=%22default%22,module=JMS,serviceType=Queue,name=%22DLQ%22/browse()"))
        .willReturn(aResponse().withBody(s)));
    }

    @Test
    public void sampleTest() throws MalformedObjectNameException, J4pException {
        System.out.println(this.artemisJolokiaClient.getTotalDeadLetterQueueSize());
    }

}
