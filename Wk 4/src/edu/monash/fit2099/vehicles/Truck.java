package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

public class Truck extends Vehicle {

    private int capacity;
    private int wheels;


    public Truck(String carMake, String carModel, int newCapacity, int newWheels) {
        super(carMake, carModel);
        capacity = newCapacity;
        wheels = newWheels;

    }

    public Truck(String carMake, String carModel, int newVId, int newCapacity, int newWheels) {
        super(carMake, carModel, newVId);
        capacity = newCapacity;
        wheels = newWheels;

    }
}
