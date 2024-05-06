package io;

import java.util.List;

public class OutputProcessor {

    public void getBidsInfo(List<BidInfo> bidInfos) {
        bidInfos.forEach(
                bidInfo -> System.out.println(
                       "Item ID:" + bidInfo.getItemID()
                                + " Bid:" + bidInfo.getBid()
                                + " Bidder Name:" + bidInfo.getBidder()));
    }

    public void printResult(boolean result) {
        if (result) {
            System.out.println("Bid placed successfully!");
        } else {
            System.out.println("Failed to place bid, there might be a higher bid already.");
        }
    }
}
