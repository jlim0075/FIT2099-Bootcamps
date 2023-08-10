import java.util.ArrayList;
import java.util.Random;

public class Car {

    private String make;
    private String model;

    ArrayList<Bid> bids = new ArrayList<Bid>();

    public Car(String CarMake, String CarModel){
        make = CarMake;
        model = CarModel;
    }


    public String description(){

        return "Maker:" + make + " and Model:" + model;

    }

    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public void addBid(Buyer newBuyer, int price, String date){
        Bid bid = new Bid(nextID(),newBuyer,price,date);
        bids.add(bid);


    }

    }

