package edu.monash.fit2099.vehicles;

import edu.monash.fit2099.vehicles.Vehicle;

public class Sedan extends Vehicle {
    private int seats;


    public Sedan(String carMake, String carModel, int newSeats) {
        super(carMake, carModel);
        seats = newSeats;
    }

    public Sedan(String carMake, String carModel, int newVId, int newSeats){
        super(carMake, carModel, newVId);
        seats = newSeats;

    }







}
