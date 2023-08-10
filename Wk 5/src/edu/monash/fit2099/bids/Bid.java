/**
 *
 * Author Julian Lim Kah Chun
 * Version 1.0
 *
 *
 */


package edu.monash.fit2099.bids;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Bid {

    private int bidId;
    private Buyer buyer = Buyer.getInstance ("Unknown", "Unknown");
    private int bidPrice;
    private LocalDate bidDate;


    /**
     * This method creates a bid with the inputs given by assigning input
     * values to the designated variables
     *
     * @param newBidId Represents the bid ID
     * @param newBidPrice Represents the amount the user wants to bid on the vehicle
     * @param day Day of the month
     * @param month Month of the year
     * @param year The year the bid is made
     * @throws BidException if any of the input given is invalid
     */
    public Bid(int newBidId,int newBidPrice, int day, int month, int year) throws BidException {
        if (setBidPrice(newBidPrice) && setBidDate(day,month,year)){
            bidId = newBidId;

        }
        else {
            throw new BidException("Incorrect price or date");
        }

    }

    /**
     *
     * The method assigns the ID given as the bidID
     *
     * @param newBidId The ID value to be set as the bidId
     */
    public void setBidId(int newBidId) {
        bidId = newBidId;
    }

    /**
     * The method sets the given price as the Bid price if it fits the
     * requirements
     *
     *
     * @param newBidPrice Represents the desired price value to be set as the
     *                    bid price
     * @return boolean Returns a boolean telling whether it was successful
     */
    public boolean setBidPrice(int newBidPrice) {
        boolean isValid = false;
        if (newBidPrice >= 0){
            isValid = true;
            bidPrice = newBidPrice;
        }
        return isValid;
    }


    /**
     *
     * The method sets the bid date given the inputs,also checks if the inputs
     * are valid or not.
     *
     * @param day Day of the month
     * @param month Month of the year
     * @param year The year of the bid made
     * @return boolean Returns a boolean telling whether the method was able to
     * assign the value or not
     */
    public boolean setBidDate(int day, int month, int year) {
        boolean isValid = false;
        if ((day >= 1 && day<= 31) && (month >= 1 && month <= 12) && (year >= 1930 && year <= 2021)) {
            String text = day + "/" + month + "/" + year;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate date = LocalDate.parse(text, formatter);
            bidDate = date;

            isValid = true;
        }
        return isValid;
    }

    /**
     *
     * The method returns the bid ID for a specific vehicle
     * @return int Returns the bidID
     */
    public int getBidId() {
        return bidId;
    }

    /**
     *
     * The method returns the bid price for the specific vehicle
     *
     * @return int Returns the bid price
     */
    public int getBidPrice() {
        return bidPrice;
    }

    /**
     *The method returns the date the bid was made for the specific vehicle
     *
     * @return LocalDate Returns the date of the bid
     */
    public LocalDate getBidDate() {
        return bidDate;
    }


    /**
     *
     * The method displays the bids attributes in a given order
     *
     * @return String Returns a string of the bid details
     */
    public String displayBid(){
        return  "Bid ID: " + bidId + ", Bid Price: " + bidPrice + "Bid Date: " + bidDate;


    }


}
