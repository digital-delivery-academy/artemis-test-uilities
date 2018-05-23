package academy.dd.artemis.dlq;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DLQMessage {

    private String JMSType;
    private String JMSMessageID;
    private String OriginalDestination;
    private String JMSTimestamp;
    private String JMSXUserID;
    private String JMSXGroupSeq;
    private String Text;
    private String JMSDeliveryMode;
    private String JMSReplyTo;
    private String JMSXGroupID;
    private String JMSDestination;
    private String JMSCorrelationID;
    private String PropertiesText;
    private int JMSExpiration, JMSPriority;
    private boolean JMSRedelivered;
    private Object ShortProperties, ByteProperties, LongProperties, IntProperties,
            DoubleProperties, BooleanProperties, FloatProperties;

    private StringProperties stringProperties;

    public String getJMSType() {
        return JMSType;
    }

    @JsonProperty("JMSType")
    public void setJMSType(String JMSType) {
        this.JMSType = JMSType;
    }

    public String getJMSMessageID() {
        return JMSMessageID;
    }

    @JsonProperty("JMSMessageID")
    public void setJMSMessageID(String JMSMessageID) {
        this.JMSMessageID = JMSMessageID;
    }

    public String getOriginalDestination() {
        return OriginalDestination;
    }

    @JsonProperty("OriginalDestination")
    public void setOriginalDestination(String originalDestination) {
        OriginalDestination = originalDestination;
    }

    public String getJMSTimestamp() {
        return JMSTimestamp;
    }

    @JsonProperty("JMSTimestamp")
    public void setJMSTimestamp(String JMSTimestamp) {
        this.JMSTimestamp = JMSTimestamp;
    }

    public String getJMSXUserID() {
        return JMSXUserID;
    }

    @JsonProperty("JMSXUserID")
    public void setJMSXUserID(String JMSXUserID) {
        this.JMSXUserID = JMSXUserID;
    }

    public String getJMSXGroupSeq() {
        return JMSXGroupSeq;
    }

    @JsonProperty("JMSXGroupSeq")
    public void setJMSXGroupSeq(String JMSXGroupSeq) {
        this.JMSXGroupSeq = JMSXGroupSeq;
    }

    public String getText() {
        return Text;
    }

    @JsonProperty("Text")
    public void setText(String text) {
        Text = text;
    }

    public String getJMSDeliveryMode() {
        return JMSDeliveryMode;
    }

    @JsonProperty("JMSDeliveryMode")
    public void setJMSDeliveryMode(String JMSDeliveryMode) {
        this.JMSDeliveryMode = JMSDeliveryMode;
    }

    public Object getIntProperties() {
        return IntProperties;
    }

    @JsonProperty("IntProperties")
    public void setIntProperties(Object intProperties) {
        this.IntProperties = intProperties;
    }

    public String getJMSReplyTo() {
        return JMSReplyTo;
    }

    @JsonProperty("JMSReplyTo")
    public void setJMSReplyTo(String JMSReplyTo) {
        this.JMSReplyTo = JMSReplyTo;
    }

    public String getJMSXGroupID() {
        return JMSXGroupID;
    }

    @JsonProperty("JMSXGroupID")
    public void setJMSXGroupID(String JMSXGroupID) {
        this.JMSXGroupID = JMSXGroupID;
    }

    public String getJMSDestination() {
        return JMSDestination;
    }

    @JsonProperty("JMSDestination")
    public void setJMSDestination(String JMSDestination) {
        this.JMSDestination = JMSDestination;
    }

    public String getJMSCorrelationID() {
        return JMSCorrelationID;
    }

    @JsonProperty("JMSCorrelationID")
    public void setJMSCorrelationID(String JMSCorrelationID) {
        this.JMSCorrelationID = JMSCorrelationID;
    }

    public String getPropertiesText() {
        return PropertiesText;
    }

    @JsonProperty("PropertiesText")
    public void setPropertiesText(String propertiesText) {
        PropertiesText = propertiesText;
    }

    public int getJMSExpiration() {
        return JMSExpiration;
    }

    @JsonProperty("JMSExpiration")
    public void setJMSExpiration(int JMSExpiration) {
        this.JMSExpiration = JMSExpiration;
    }

    public int getJMSPriority() {
        return JMSPriority;
    }

    @JsonProperty("JMSPriority")
    public void setJMSPriority(int JMSPriority) {
        this.JMSPriority = JMSPriority;
    }

    public boolean isJMSRedelivered() {
        return JMSRedelivered;
    }

    @JsonProperty("JMSRedelivered")
    public void setJMSRedelivered(boolean JMSRedelivered) {
        this.JMSRedelivered = JMSRedelivered;
    }

    public Object getShortProperties() {
        return ShortProperties;
    }

    @JsonProperty("ShortProperties")
    public void setShortProperties(Object shortProperties) {
        ShortProperties = shortProperties;
    }

    public Object getByteProperties() {
        return ByteProperties;
    }

    @JsonProperty("ByteProperties")
    public void setByteProperties(Object byteProperties) {
        ByteProperties = byteProperties;
    }

    public Object getLongProperties() {
        return LongProperties;
    }

    @JsonProperty("LongProperties")
    public void setLongProperties(Object longProperties) {
        LongProperties = longProperties;
    }

    public StringProperties getStringProperties() {
        return stringProperties;
    }

    @JsonProperty("StringProperties")
    public void setStringProperties(StringProperties stringProperties) {
        this.stringProperties = stringProperties;
    }

    public Object getDoubleProperties() {
        return DoubleProperties;
    }

    @JsonProperty("DoubleProperties")
    public void setDoubleProperties(Object doubleProperties) {
        DoubleProperties = doubleProperties;
    }

    public Object getBooleanProperties() {
        return BooleanProperties;
    }

    @JsonProperty("BooleanProperties")
    public void setBooleanProperties(Object booleanProperties) {
        BooleanProperties = booleanProperties;
    }

    public Object getFloatProperties() {
        return FloatProperties;
    }

    @JsonProperty("FloatProperties")
    public void setFloatProperties(Object floatProperties) {
        FloatProperties = floatProperties;
    }
}
