/**
 *
 * Author Julian Lim Kah Chun
 * Version 1.0
 *
 */
package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;

public class Truck extends Vehicle {

    private int capacity;
    private int wheels;

    /**
     *
     *A constructor that uses the vehicle class to
     * initialise attributes and also the Truck unique attributes
     * given the inputs.Will throw an error if any of the inputs are
     * invalid
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @param newCapacity Represents the amount of capacity input
     * @param newWheels Represents the number of wheels input
     * @throws TruckException if the capacity or number of wheels given is valid
     */
    public Truck(String carMake, String carModel, int newCapacity, int newWheels) throws VehicleException {
        super(carMake, carModel);
        if (!setCapacity(newCapacity) | !setWheels(newWheels)){
           throw new  TruckException("Invalid capacity or number of wheels");
        }

    }

    /**
     *
     *A constructor that uses the vehicle class to
     * initialise attributes and also the Truck unique attributes
     * given the inputs.Will throw an error if any of the inputs are
     * invalid
     *
     * @param carMake This input represents the car maker
     * @param carModel This is the car model input
     * @param newCapacity Represents the amount of capacity input
     * @param newWheels Represents the number of wheels input
     * @param newVId Represents the vehicle id input
     * @throws TruckException if the capacity or number of wheels given is valid
     */
    public Truck(String carMake, String carModel, int newVId, int newCapacity, int newWheels) throws VehicleException {
        super(carMake, carModel, newVId);
        if (!setCapacity(newCapacity) | !setWheels(newWheels)){
            throw new  TruckException("Invalid capacity or number of wheels");
        }
    }


    /**
     *The method assigns the input value to capacity.If it meets the
     *requirements,will assign the value and return true else it will
     *return false
     *
     * @param newCap Represents the input value to be assigned to capacity
     * @return boolean Returns a boolean telling whether the method was able to
     * assign the value or not
     */
    public boolean setCapacity(int newCap) {
        boolean isValid=false;
        if(newCap >= 1 && newCap <= 15){
            isValid=true;
            capacity = newCap;
        }
        return isValid;
    }

    /**
     *The method assigns the input value to wheels.If it meets the
     *requirements,will assign the value and return true else it will
     *return false
     *
     * @param newWheels Represents the input value to be assigned to wheels
     * @return boolean Returns a boolean telling whether the method was able to
     * assign the value or not
     */
    public boolean setWheels(int newWheels) {
        boolean isValid=false;
        if(newWheels >= 1 && newWheels <= 15){
            isValid=true;
            wheels = newWheels;
        }
        return isValid;

    }
}
