package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;

import java.util.Random;

public class Bid {

    private int bidId;
    private Buyer buyer = new Buyer(0000);
    private int bidPrice;
    private String bidDate;



//    public Bid(int newBidId, Buyer newBuyer, int newBidPrice, String newBidDate){
//        bidId = newBidId;
//        buyer = newBuyer;
//        bidPrice = newBidPrice;
//        bidDate = newBidDate;
//
//    }

    public Bid(int newBidId,int newBidPrice, String newBidDate){
        bidId = newBidId;
        bidPrice = newBidPrice;
        bidDate = newBidDate;


    }

    public void setBidId(int newBidId) {
        bidId = newBidId;
    }

    public void setBuyer(Buyer newBuyer){
        buyer = newBuyer;
    }

    public void setBidPrice(int newBidPrice) {
        bidPrice = newBidPrice;
    }

    public void setBidDate(String newBidDate) {
        bidDate = newBidDate;
    }


    public int getBidId() {
        return bidId;
    }

    public Buyer getBuyer(){
        return buyer;
    }

    public int getBidPrice() {
        return bidPrice;
    }

    public String getBidDate() {
        return bidDate;
    }


    public String displayBid(){
        return  "Bid ID: " + bidId + ", Bid Price: " + bidPrice + "Bid Date: " + bidDate;


    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;//using literal values is not a good idea, replace them with input parameters
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }



}
