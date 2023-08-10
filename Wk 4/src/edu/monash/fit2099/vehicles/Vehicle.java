package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidManager;

import java.util.Random;

abstract public class Vehicle {

    private String make;
    private String model;
    private int vId;
    private BidManager bidManager = new BidManager();


    public Vehicle(String carMake, String carModel){
        make = carMake;
        model = carModel;
        vId = nextID();
    }


    public Vehicle(String carMake, String carModel, int newVId){
        make = carMake;
        model = carModel;
        vId = newVId;
    }


    public String description(){

        return vId + "|" + make + "|" + model;

    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public int getVId() {
        return vId;
    }


    public void addToBidManager(int buyerId, int bidPrice, String bidDate){
        bidManager.addBid(buyerId, bidPrice, bidDate);

    }






    public BidManager getBidManager() {
        return bidManager;
    }
}

