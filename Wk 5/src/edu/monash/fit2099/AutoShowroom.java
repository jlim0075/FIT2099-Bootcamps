/**
 * This class represents the AutoShowroom where it manages every other
 * class function such as adding cars,adding buyers and even adding bids
 *
 * @author Julian Lim Kah Chun
 * @version 1.0
 *
 *
 */




package edu.monash.fit2099;

import edu.monash.fit2099.bids.Bid;
import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoShowroom {


    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Buyer> buyers = new ArrayList<Buyer>();


    public void printStatus() throws BidException {
//        System.out.println("Welcome to FIT2099 Showroom");
//        System.out.println("Thank you for visiting FIT2099 Showroom");

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
     *This method takes in input from the user and makes a Sedan object
     * according to the input given and also adds it into a vehicle list
     *
     * @throws SedanException if does not fit the requirements to make a Sedan
     * @throws VehicleException if invalid input given for Model and Maker
     *
     */
    public void createSedan()  {

        System.out.println("Please enter car maker: ");
        Scanner maker = new Scanner(System.in);
        String carMaker = maker.nextLine();


        System.out.println("Please enter car model: ");
        Scanner model = new Scanner(System.in);
        String carModel = model.nextLine();

        System.out.println("Please enter car seats: ");
        Scanner seat = new Scanner(System.in);
        int truckSeats = seat.nextInt();

        try {
            Sedan sedan = new Sedan(carMaker, carModel,nextID(),truckSeats);

            vehicles.add(sedan);
            System.out.println("Sedan has been added");
        } catch (SedanException e){
            System.out.println(e.getMessage());
        } catch (VehicleException e){
            System.out.println(e.getMessage());
        }

    }


    /**
     *
     *The method takes in input to make a truck object and puts in a vehicle
     * list to keep track
     * @throws TruckException if does not meet requirements to make a truck object
     * @throws VehicleException if does not meet requirements to make the model and maker
     *
     */
    public void createTruck(){
        System.out.println("Please enter car maker: ");
        Scanner maker = new Scanner(System.in);
        String carMaker = maker.nextLine();


        System.out.println("Please enter car model: ");
        Scanner model = new Scanner(System.in);
        String carModel = model.nextLine();

        System.out.println("Please enter car capacity: ");
        Scanner capacity = new Scanner(System.in);
        int truckCap = capacity.nextInt();

        System.out.println("Please enter number of car wheels: ");
        Scanner wheels = new Scanner(System.in);
        int truckWheels = wheels.nextInt();

        try{
            Truck truck = new Truck(carMaker, carModel,nextID(),truckCap,truckWheels);
            vehicles.add(truck);
            System.out.println("New truck has been added");
        }
        catch (TruckException e){
            System.out.println(e.getMessage());
        }
        catch (VehicleException e){
            System.out.println(e.getMessage());

        }

    }

    /**
     *
     * This method creates a buyer object and adds it into a list to keep track
     * of the buyers
     *
     *
     */
    public void createBuyer(){

        System.out.println("Please enter your given name: ");
        Scanner firstName = new Scanner(System.in);
        String givenName = firstName.nextLine();

        System.out.println("Please enter your family name: ");
        Scanner lastName = new Scanner(System.in);
        String familyName = lastName.nextLine();

        Buyer buyer = Buyer.getInstance(givenName,familyName);
        assert buyer != null;
        buyer.setBuyerId(nextID());

        if (buyer != null) {
            buyers.add(buyer);
            System.out.println(buyer);
            System.out.println("Buyer has been added");
        } else
            System.out.println("Something wrong with the buyer's values!!!");



    }


    /**
     * Makes a new bid on a specific vehicle where the price,buyerID and date
     * are given as input.From there,the bid will be added to a hashmap of bids
     * the vehicle has.
     *
     * @throws BidException if input given to make a bid is wrong
     */
    public void createBid(){
        System.out.println("Please enter vehicle ID: ");
        Scanner idInput = new Scanner(System.in);
        int vehicleId = idInput.nextInt();

        System.out.println("Please enter buyer ID: ");
        Scanner secondIdInput = new Scanner(System.in);
        int buyerId = secondIdInput.nextInt();

        System.out.println("Please enter the price: ");
        Scanner priceInput = new Scanner(System.in);
        int price = priceInput.nextInt();

        System.out.println("Please enter the date [Day of the month]: ");
        Scanner dayInput = new Scanner(System.in);
        int day = dayInput.nextInt();

        System.out.println("Please enter the date [Month of the year]: ");
        Scanner monthInput = new Scanner(System.in);
        int month = monthInput.nextInt();

        System.out.println("Please enter the date [The year]: ");
        Scanner yearInput = new Scanner(System.in);
        int year = yearInput.nextInt();

        try{
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getVId() == vehicleId) {
                    vehicle.addToBidManager(buyerId, price, day, month, year);
                }
                System.out.println("Bid has been added");
            }
        }
        catch (BidException e){
            System.out.println(e.getMessage());
        }

        }

    /**
     *Displays all vehicles created from the list and the bids each
     * vehicle has
     *
      */
    public void displayFleet(){
        System.out.print("[");
        for (int x = 0; x< vehicles.size(); x++) {
            System.out.print(vehicles.get(x).description() + "|" + "{");
            for (int key : vehicles.get(x).getBidManager().getHashMap().keySet()) {
                if (key == vehicles.get(x).getBidManager().getHashMap().size() - 1) {
                    System.out.print("[Bid ID: " + vehicles.get(x).getBidManager().getHashMap().get(key).getBidId()
                            + "," + " buyerId: " + key + ", price: ");
                    System.out.print(vehicles.get(x).getBidManager().getHashMap().get(key).getBidPrice() +
                            ", date: " + vehicles.get(x).getBidManager().getHashMap().get(key).getBidDate() + "]");
                } else {
                    System.out.print("[Bid ID: " + vehicles.get(x).getBidManager().getHashMap().get(key).getBidId()
                            + "," + " buyerId: " + key + ", price: ");
                    System.out.print(vehicles.get(x).getBidManager().getHashMap().get(key).getBidPrice() +
                            ", date: " + vehicles.get(x).getBidManager().getHashMap().get(key).getBidDate() + "], ");
                }
            }
            if (x == (vehicles.size() - 1)) {
                System.out.print("}");
            }
            else {
                System.out.print("}, ");

            }

        }
        System.out.print("]");
        System.out.println();

    }

    /**
     * Displays all created buyers showcasing their IDs,given name and family name
     * from the list made.
     *
     *
     */
    public void displayBuyers(){
        System.out.print("[");
        for (int x = 0; x < buyers.size(); x++){
            System.out.print(buyers.get(x).description());
            if (x == (buyers.size() - 1)){
                System.out.print("]");
            }
            else {
                System.out.print(", ");
            }
        }
        System.out.println();
    }


    /**
     * Given the vehicle ID,the method finds the highest bid (in terms of
     * price) a vehicle has and displays the bid.
     *
     *
     */
    public void highestBid(){
        System.out.println("Please enter vehicle ID: ");
        Scanner idInput = new Scanner(System.in);
        int vehicleId = idInput.nextInt();
        int bidPrice = 0;
        int keyVal = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVId() == vehicleId) {
                for (int key : vehicle.getBidManager().getHashMap().keySet()){
                    if (vehicle.getBidManager().getHashMap().get(key).getBidPrice() > bidPrice){
                        bidPrice = vehicle.getBidManager().getHashMap().get(key).getBidPrice();
                        keyVal = key;

                    }

                }
                if (bidPrice == 0){
                    System.out.println("Bid could not be found based on bid ID given");
                    break;
                }
                System.out.print("[Bid ID: " + vehicle.getBidManager().getHashMap().get(keyVal).getBidId()
                        + "," + " buyerId: " + keyVal + ", price: ");
                System.out.print(vehicle.getBidManager().getHashMap().get(keyVal).getBidPrice() +
                        ", date: " + vehicle.getBidManager().getHashMap().get(keyVal).getBidDate() + "]");

            }
            else {
                System.out.println("Vehicle not found based on vehicle ID given");
            }


            }


    }


    /**
     *
     *
     * Given the vehicle ID,the method finds the lowest bid (in terms of
     * price) a vehicle has and displays the bid.
     *
     */
    public void lowestBid(){
        System.out.println("Please enter vehicle ID: ");
        Scanner idInput = new Scanner(System.in);
        int vehicleId = idInput.nextInt();
        int keyVal = 0;
        int bidPrice = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVId() == vehicleId) {
                for (int key : vehicle.getBidManager().getHashMap().keySet()){
                    if (bidPrice > vehicle.getBidManager().getHashMap().get(key).getBidPrice()){
                        bidPrice = vehicle.getBidManager().getHashMap().get(key).getBidPrice();
                        keyVal = key;

                    }

                }
                if (bidPrice == 0){
                    System.out.println("Bid could not be found based on bid ID given");
                    break;
                }
                System.out.print("[Bid ID: " + vehicle.getBidManager().getHashMap().get(keyVal).getBidId()
                        + "," + " buyerId: " + keyVal + ", price: ");
                System.out.print(vehicle.getBidManager().getHashMap().get(keyVal).getBidPrice() +
                        ", date: " + vehicle.getBidManager().getHashMap().get(keyVal).getBidDate() + "]");
            }
            else {
                System.out.println("Vehicle not found based on vehicle ID given");
            }
        }

    }


    /**
     *
     * Given the vehicle ID and the bid ID,the method will delete the
     * bid from the vehicle
     *
     */
    public void deleteBid() {
        displayFleet();

        System.out.println("Please enter vehicle ID: ");
        Scanner idInput = new Scanner(System.in);
        int vehicleId = idInput.nextInt();

        System.out.println("Please enter bid ID to delete: ");
        Scanner bidInput = new Scanner(System.in);
        int bidID = idInput.nextInt();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVId() == vehicleId) {
                for (int key : vehicle.getBidManager().getHashMap().keySet()) {
                    if (vehicle.getBidManager().getHashMap().get(key).getBidId() == bidID) {
                        vehicle.getBidManager().getHashMap().remove(key);
                        System.out.println("Bid has been removed");
                        break;
                    }
                }
                System.out.println("Bid could not be found");
            } else {
                System.out.println("Vehicle not found based on vehicle ID given");
            }
        }

    }
    }



















