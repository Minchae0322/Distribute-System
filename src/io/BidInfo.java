package io;


import java.io.Serializable;

public class BidInfo implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private final String itemID;

    private final Double bid;

    private final String bidder;

    public BidInfo(String itemID, Double bid, String bidder) {
        this.itemID = itemID;
        this.bid = bid;
        this.bidder = bidder;
    }

    public String getItemID() {
        return itemID;
    }

    public Double getBid() {
        return bid;
    }

    public String getBidder() {
        return bidder;
    }
}
