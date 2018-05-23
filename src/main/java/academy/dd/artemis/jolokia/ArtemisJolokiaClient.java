package academy.dd.artemis.jolokia;

import academy.dd.artemis.dlq.DLQMessage;
import academy.dd.artemis.date.DateTimeCalculator;
import academy.dd.artemis.date.Day;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pExecRequest;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;
import org.jolokia.client.request.J4pResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.management.MalformedObjectNameException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ArtemisJolokiaClient {

    /**
     * TODO:
     *  - Check within time period for timestamps
     */

    private J4pClient j4pClient;
    private final String JOLOKIA_URL = "http://localhost:4444/jolokia";
    private final String DLQ_MBEAN_NAME = "org.apache.activemq.artemis:type=Broker,brokerName=\"default\",module=JMS,serviceType=Queue,name=\"DLQ\"";

    public ArtemisJolokiaClient() {
        this.j4pClient = J4pClient.url(JOLOKIA_URL).build();
    }

    public Long getTotalDeadLetterQueueSize() throws MalformedObjectNameException, J4pException {
        J4pReadRequest req = new J4pReadRequest(DLQ_MBEAN_NAME);
        J4pReadResponse resp = j4pClient.execute(req);
        JSONObject json = resp.getValue();
        return (Long) json.get("MessageCount");
    }

    public int getDeadLetterQueueSizeForDate(Day day) throws Exception {
        DateTimeCalculator dateTimeCalculator = new DateTimeCalculator(day);
        return getListOfDeadLetterQueueMessagesForDate(dateTimeCalculator).size();
    }

    public int getDeadLetterQueueSizeForDate(String date) throws Exception {
        DateTimeCalculator dateTimeCalculator = new DateTimeCalculator(date);
        return getListOfDeadLetterQueueMessagesForDate(dateTimeCalculator).size();
    }

    private List<DLQMessage> getListOfDeadLetterQueueMessagesForDate(DateTimeCalculator dateTimeCalculator)
            throws J4pException, MalformedObjectNameException, IOException {
        List<DLQMessage> dlqMessages = getDeadLetterQueueMessages();
        List<DLQMessage> datedDlqMessages = new ArrayList();
        for(DLQMessage dlqMessage : dlqMessages) {
            if(dlqMessage.getJMSTimestamp().contains(dateTimeCalculator.getDate())) {
                datedDlqMessages.add((dlqMessage));
            }
        }
        return datedDlqMessages;
    }

    private List<DLQMessage> getDeadLetterQueueMessages()
            throws IOException, J4pException, MalformedObjectNameException {
        J4pExecRequest req = new J4pExecRequest(DLQ_MBEAN_NAME, "browse()");
        J4pResponse<J4pExecRequest> resp = j4pClient.execute(req);
        JSONArray json = resp.getValue();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json.toJSONString(), new TypeReference<List<DLQMessage>>(){});
    }

    public List<String> analyseDeadLetterQueueMessages() throws MalformedObjectNameException, J4pException, IOException {
        List<String> analysedMessages = new ArrayList();

        for(DLQMessage dlqMessage : getDeadLetterQueueMessages()) {
            String report = new StringBuilder("CPP Event: ")
                    .append(dlqMessage.getStringProperties().getCppName())
                    .append(". Queue: ")
                    .append(dlqMessage.getStringProperties().getAmqOriginalQueue())
                    .toString();
            analysedMessages.add(report);
        }

        return analysedMessages;
    }
}