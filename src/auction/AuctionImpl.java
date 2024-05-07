package auction;

import auction.Auction;
import io.BidInfo;

import java.rmi.RemoteException;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuctionImpl extends UnicastRemoteObject implements Auction {

    private static AuctionImpl instance;
    private final Map<String, Double> currentBids;
    private final Map<String, String> highestBidder;

    private AuctionImpl() throws RemoteException {
        super();
        currentBids = new HashMap<>();
        highestBidder = new HashMap<>();
    }

    public static AuctionImpl getInstance() throws RemoteException{
        if (instance == null) {
            return new AuctionImpl();
        }
        return instance;
    }

    @Override
    public synchronized boolean placeBid(String itemID, double bid, String bidderName) throws RemoteException {
        Double currentBid = currentBids.getOrDefault(itemID, 0.0);
        if (bid > currentBid) {
            currentBids.put(itemID, bid);
            highestBidder.put(itemID, bidderName);
            return true;
        }
        return false;
    }

    @Override
    public synchronized String getCurrentBid(String itemID) throws RemoteException {
        return "Item ID: " + itemID + ", Highest Bid: " + currentBids.get(itemID) + ", Bidder: " + highestBidder.get(itemID);
    }

    @Override
    public List<BidInfo> getBidsInfo() throws RemoteException {
        List<BidInfo> bidInfos = new ArrayList<>();

        for (String itemId : currentBids.keySet()) {
            Double bidAmount = currentBids.get(itemId);
            String bidderName = highestBidder.get(itemId);
            bidInfos.add(new BidInfo(itemId, bidAmount, bidderName));
        }
        return bidInfos;
    }
}
