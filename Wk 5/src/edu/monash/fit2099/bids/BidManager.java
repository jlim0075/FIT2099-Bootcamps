/**
 *
 * Author Julian Lim Kah Chun
 * Version 1.0
 *
 */
package edu.monash.fit2099.bids;

import edu.monash.fit2099.exceptions.BidException;

import java.util.HashMap;
import java.util.Random;

public class BidManager {
    private HashMap<Integer, Bid > hashMap = new HashMap<Integer, Bid>();


    /**
     *
     * This methods makes a new hashMap object to be used to store
     * bids for a specific vehicle
     *
     */
    public BidManager(){
        HashMap<Integer, Bid > hashMap = new HashMap<Integer, Bid>();

    }

    /**
     *
     * This method makes a bid object with the input given and then
     * adds it into a hash map to keep track of the bids a vehicle will
     * have
     *
     * @param buyerId Represents the buyer ID
     * @param bidPrice Represents the price given by the user to bid
     * @param day Day of the month
     * @param month Month of the year
     * @param year The year the bid was made
     * @throws BidException if any of the inputs given is invalid
     */
    public void addBid(int buyerId, int bidPrice, int day, int month, int year) throws BidException {
        Bid newBid = new Bid(nextID(),bidPrice,day,month,year);
        hashMap.put(buyerId,newBid);


    }

    /**
     * The method returns the hashmap of the specific vehicle used
     *
     * @return HashMap Returns the hashMap of a vehicle allowing to access
     * the bids in the hashmap
     */
    public HashMap<Integer, Bid> getHashMap(){
        return hashMap;
    }


    /**
     * This method generates a random amount of number (5 digit numbers)
     * This will be used as IDs for vehicleIDs,buyerIDs and also bidIDs
     *
     * @return int This will return a 5 digit number representing an ID
     */
    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }



}



