package auction;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class AuctionServer {
    public static void main(String[] args) {
        try {
            AuctionImpl auction = new AuctionImpl();
            Registry registry = LocateRegistry.createRegistry(Instance.PORT); // RMI 기본 포트
            registry.bind(Instance.AUCTION_REGISTRY_NAME, auction);
            System.out.println("auction.Auction server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
