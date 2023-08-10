import java.util.ArrayList;

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

    public void addBid(Buyer newBuyer, int price, String date){


    }

}
