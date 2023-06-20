package org.example.data;

public class CardEntity {
    String rangeStart;
    String rangeEnd;
    String type;
    String active;
    Network network;

    enum Network {
        VISA_CARD,
        MASTER_CARD
    }


    public CardEntity(String rangeStart, String rangeEnd, String type, String active, Network network) {
        super();
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
        this.type = type;
        this.active = active;
        this.network = network;
    }

    public CardEntity() {
    }

    public String getRangeStart() {
        return rangeStart;
    }

    public void setRangeStart(String rangeStart) {
        this.rangeStart = rangeStart;
    }

    public String getRangeEnd() {
        return rangeEnd;
    }

    public void setRangeEnd(String rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Network getNetwork() {
        return network;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    @Override
    public String toString() {
        return "MasterCard{" +
                "rangeStart='" + rangeStart + '\'' +
                ", rangeEnd='" + rangeEnd + '\'' +
                ", type='" + type + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
