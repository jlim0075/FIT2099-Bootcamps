package edu.monash.fit2099;

import edu.monash.fit2099.buyers.Buyer;
import edu.monash.fit2099.vehicles.Sedan;
import edu.monash.fit2099.vehicles.Truck;
import edu.monash.fit2099.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoShowroom {


    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    ArrayList<Buyer> buyers = new ArrayList<Buyer>();


    public void printStatus() {
//        System.out.println("Welcome to FIT2099 Showroom");
//        System.out.println("Thank you for visiting FIT2099 Showroom");

        int selection;
        do{
            selection = selectMenuItem();
            switch (selection) {
                case 1 -> createSedan();
                case 2 -> createTruck();
                case 3 -> displayFleet();
                case 4 -> createBuyer();
                case 5 -> displayBuyers();
                case 6 -> createBid();
            }
        }while (selection <7);
    }




    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public void createSedan(){
        System.out.println("Please enter car maker: ");
        Scanner maker = new Scanner(System.in);
        String carMaker = maker.nextLine();


        System.out.println("Please enter car model: ");
        Scanner model = new Scanner(System.in);
        String carModel = model.nextLine();

        System.out.println("Please enter car seats: ");
        Scanner seat = new Scanner(System.in);
        int truckSeats = seat.nextInt();

        Sedan sedan = new Sedan(carMaker, carModel,nextID(),truckSeats);

        vehicles.add(sedan);

        System.out.println("Sedan has been added");


    }

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


        Truck truck = new Truck(carMaker, carModel,nextID(),truckCap,truckWheels);

        vehicles.add(truck);

        System.out.println("New truck has been added");

    }

    public void createBuyer(){

        System.out.println("Please enter your given name: ");
        Scanner firstName = new Scanner(System.in);
        String givenName = firstName.nextLine();

        System.out.println("Please enter your family name: ");
        Scanner lastName = new Scanner(System.in);
        String familyName = lastName.nextLine();

        Buyer buyer = new Buyer(nextID(),givenName,familyName);

        buyers.add(buyer);

        System.out.println("Buyer has been added");

    }

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

        System.out.println("Please enter the date: ");
        Scanner dateInput = new Scanner(System.in);
        String date = dateInput.nextLine();


        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVId() == vehicleId) {
                vehicle.addToBidManager(buyerId, price, date);
            }
            System.out.println("Bid has been added");
        }

    }

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
                        System.out.print("Bid ID: " + vehicles.get(x).getBidManager().getHashMap().get(key).getBidId()
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

    public static int selectMenuItem(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("| Bootcamp Week 3 |");
        System.out.println("-------------------");
        System.out.println("1) New Sedan ");
        System.out.println("2) New Truck ");
        System.out.println("3) Display Fleet ");
        System.out.println("4) Add Buyer ");
        System.out.println("5) List Buyers ");
        System.out.println("6) Add Bid ");
        System.out.println("7) Exit ");
        System.out.println();
        System.out.println("_______________________");
        return scanner.nextInt();


    }



    }

















