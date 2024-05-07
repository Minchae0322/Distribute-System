package auction;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuctionServer {
    public static void main(String[] args) {
        try {
            AuctionImpl auction = AuctionImpl.getInstance();
            Registry registry = LocateRegistry.createRegistry(Instance.PORT);

            registry.bind(Instance.AUCTION_REGISTRY_NAME, auction);

            System.out.println("Auction server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
