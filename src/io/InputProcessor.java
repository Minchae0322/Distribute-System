package io;

import auction.Auction;
import io.BidInfo;

import java.rmi.RemoteException;
import java.util.Scanner;


public class InputProcessor {

    private static final String INPUT_ITEM_ID_MESSAGE = "请输入 Item ID:";
    private static final String INPUT_BID_MESSAGE = "请输入 Bid:";

    private static final String INPUT_NAME_MESSAGE = "请输入 Name:";
    private final Scanner scanner;

    private final Auction auction;


    public InputProcessor(Auction stub) {
        this.scanner = new Scanner(System.in);
        auction = stub;
    }

    public BidInfo inputBidInfo() throws RemoteException {
        System.out.println(INPUT_ITEM_ID_MESSAGE);
        String itemID = scanner.nextLine();
        System.out.println(auction.getCurrentBid(itemID));

        System.out.println(INPUT_BID_MESSAGE);
        double bid = scanner.nextDouble();

        scanner.nextLine();
        System.out.println(INPUT_NAME_MESSAGE);
        String name = scanner.nextLine();

        return new BidInfo(itemID, bid, name);
    }
}
