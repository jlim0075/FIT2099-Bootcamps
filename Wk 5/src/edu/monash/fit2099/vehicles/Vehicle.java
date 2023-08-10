/**
 *
 * Author Julian Lim Kah Chun
 * Version 1.0
 *
 */

package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.bids.BidManager;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Random;

abstract public class Vehicle {

    private String maker;
    private String model;
    private int vId;
    private BidManager bidManager = new BidManager();


    /**
     * A method that is basically a constructor where it will
     * give values to the model,make and vehicleID given the input.It
     * will then be given a bidManager object to store bids this vehicle
     * has
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @throws VehicleException if given an invalid car maker or model
     */
    public Vehicle(String carMake, String carModel) throws VehicleException {
        if (setMaker(carMake) && setModel(carModel)){
            vId = nextID();
            bidManager= new BidManager();
        }
        else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }

    /**
     * A method that is basically a constructor where it will
     * give values to the model,make and vehicleID given the input.It
     * will then be given a bidManager object to store bids this vehicle
     * has
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @param newVId This is the vehicle id input
     * @throws VehicleException if given an invalid car maker or model
     */
    public Vehicle(String carMake, String carModel,int newVId) throws VehicleException {
        if (setMaker(carMake) && setModel(carModel)){
            vId = newVId;
            bidManager= new BidManager();
        }
        else {
            throw new VehicleException("Incorrect Maker OR Model");
        }

    }

    /**
     *
     * This method sets and provides a value given to the Maker.If the
     * input fulfills the requirements,it will set it as the value
     * and turn isValid to true to be returned telling that it has been
     * successful
     *
     *
     * @param newMaker This is the input given to be the value for the maker
     * @return boolean This will return a boolean on whether or not the maker
     * has been succesfully set
     */
    public boolean setMaker(String newMaker){
        boolean isValid=false;
        if(newMaker.length()>=3 && newMaker.length()<=15){
            isValid=true;
            maker = newMaker;
        }
        return isValid;
    }

    /**
     *
     * The method similar to setMaker assigns the given value to
     * the car model variable if it fulfills the requirements
     *
     * @param newModel Represents the input given to be the value for car model
     * @return boolean Returns a boolean telling whether the new value
     * has been accepted or not
     */
    public boolean setModel(String newModel){
        boolean isValid=false;
        if(newModel.length()>=3 && newModel.length()<=15){
            isValid=true;
            model = newModel;
        }
        return isValid;
    }

    /**
     *
     * The method returns a description of the Vehicle consisting of the
     * ID,model and maker
     *
     *
     * @return String Returns a string describing the car with it's vehicle
     * ID, car maker and car model
     */
    public String description(){

        return vId + "|" + maker + "|" + model;

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

    /**
     * The method returns the value of the vehicle ID
     *
     * @return int Returns the vehicle ID
     */
    public int getVId() {
        return vId;
    }

    /**
     *This method makes a bid and adds it to the Bid Manager
     *given the inputs needed
     *
     *
     * @param buyerId The id of the buyer
     * @param bidPrice The price the buyer wants to bid
     * @param day The day of the month
     * @param month The month of the year
     * @param year The year
     * @throws BidException if one of the inputs given is invalid
     */
    public void addToBidManager(int buyerId, int bidPrice, int day, int month, int year) throws BidException {
        bidManager.addBid(buyerId, bidPrice, day, month, year);

    }


    /**
     *
     *
     * This method returns the Bid Manager object
     * @return bidManager Returns the bid manager object allowing access
     * to the information.
     */
    public BidManager getBidManager() {
        return bidManager;
    }
}

