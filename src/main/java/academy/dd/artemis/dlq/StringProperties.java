package academy.dd.artemis.dlq;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StringProperties {

    private String singularityHeader;
    private String amqCid;
    private String amqOriginalQueue;
    private String amqOriginalAddress;
    private String cppName;

    public String getSingularityHeader() {
        return singularityHeader;
    }

    @JsonProperty("singularityheader")
    public void setSingularityHeader(String singularityHeader) {
        this.singularityHeader = singularityHeader;
    }

    public String getAmqCid() {
        return amqCid;
    }

    @JsonProperty("__AMQ_CID")
    public void setAmqCid(String amqCid) {
        this.amqCid = amqCid;
    }

    public String getAmqOriginalQueue() {
        return amqOriginalQueue;
    }

    @JsonProperty("_AMQ_ORIG_QUEUE")
    public void setAmqOriginalQueue(String amqOriginalQueue) {
        this.amqOriginalQueue = amqOriginalQueue;
    }

    public String getAmqOriginalAddress() {
        return amqOriginalAddress;
    }

    @JsonProperty("_AMQ_ORIG_ADDRESS")
    public void setAmqOriginalAddress(String amqOriginalAddress) {
        this.amqOriginalAddress = amqOriginalAddress;
    }

    public String getCppName() {
        return cppName;
    }

    @JsonProperty("CPPNAME")
    public void setCppName(String cppName) {
        this.cppName = cppName;
    }
}
