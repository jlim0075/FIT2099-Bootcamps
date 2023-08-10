package edu.monash.fit2099.bids;

import java.util.HashMap;
import java.util.Random;

public class BidManager {
    private HashMap<Integer, Bid > hashMap = new HashMap<Integer, Bid>();

    public BidManager(){
        HashMap<Integer, Bid > hashMap = new HashMap<Integer, Bid>();


    }

    public void addBid(int buyerId, int bidPrice, String bidDate){
        Bid newBid = new Bid(nextID(),bidPrice,bidDate);
        hashMap.put(buyerId,newBid);


    }


    public HashMap<Integer, Bid> getHashMap() {
        return hashMap;
    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }



}



