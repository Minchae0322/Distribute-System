package auction;

import auction.Auction;
import io.BidInfo;
import io.InputProcessor;
import io.OutputProcessor;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class AuctionClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(Instance.HOST, Instance.PORT);
            final Auction stub = (Auction) registry.lookup(Instance.AUCTION_REGISTRY_NAME);

            OutputProcessor outputProcessor = new OutputProcessor();
            outputProcessor.getBidsInfo(stub.getBidsInfo());

            InputProcessor inputProcessor = new InputProcessor(stub);
            BidInfo bidInfo = inputProcessor.inputBidInfo();

            boolean result = stub.placeBid(bidInfo.getItemID(), bidInfo.getBid(), bidInfo.getBidder());
            outputProcessor.printResult(result);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
