package auction;

import io.BidInfo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Auction extends Remote {
    boolean placeBid(String itemID, double bid, String bidderName) throws
            RemoteException;

    String getCurrentBid(String itemID) throws RemoteException;

    List<BidInfo> getBidsInfo() throws RemoteException;

}
