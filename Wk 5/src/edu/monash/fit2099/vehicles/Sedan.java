
/**
 *
 * Author Julian Lim Kah Chun
 *
 * Version 1.0
 *
 */
package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.VehicleException;

public class Sedan extends Vehicle {
    private int seats;


    /**
     *
     *A constructor that uses the vehicle class to
     * initialise attributes and also the Sedan unique attributes
     * given the inputs.Will throw an error if any of the inputs are
     * invalid
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @param newSeats Represents the number of seats input
     * @throws VehicleException if the number of seats given is valid
     */
    public Sedan(String carMake, String carModel, int newSeats) throws VehicleException {
        super(carMake, carModel);
        if (!setSeats(newSeats)){
            throw new SedanException("Invalid number of seats");
        }
    }



    /**
     *
     *A constructor that uses the vehicle class to
     * initialise attributes and also the Sedan unique attributes
     * given the inputs.Will throw an error if any of the inputs are
     * invalid
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @param newVId This is the vehicle ID input
     * @param newSeats Represents the number of seats input
     * @throws VehicleException if the number of seats given is valid
     */
    public Sedan(String carMake, String carModel, int newVId, int newSeats) throws VehicleException {
        super(carMake, carModel, newVId);
        if (!setSeats(newSeats)){
            throw new SedanException("Invalid value of seats");
        }
    }

    /**
     *The method assigns the input value to seats.If it meets the
     *requirements,will assign the value and return true else it will
     *return false
     *
     * @param newSeats Represents the input value to be assigned to seats
     * @return boolean Returns a boolean telling whether the method was able to
     *         assign the value or not
     */
    public boolean setSeats(int newSeats) {
        boolean isValid=false;
        if(newSeats >= 4 && newSeats <= 5){
            isValid=true;
            seats = newSeats;
        }
        return isValid;
    }
}
