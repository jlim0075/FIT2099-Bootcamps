import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AutoShowroom {


    ArrayList<Car> cars = new ArrayList<Car>();

    public void printStatus() {
//        System.out.println("Welcome to FIT2099 Showroom");
//        System.out.println("Thank you for visiting FIT2099 Showroom");
        displayCars();


    }


    public int nextID() {
        Random r = new Random();
        int low = 10000;
        int high = 99999;
        return (r.nextInt(high - low) + low);
    }

    public void createCars() {

        System.out.println("Please enter car maker: ");
        Scanner maker = new Scanner(System.in);
        String carMaker = maker.nextLine();


        System.out.println("Please enter car maker: ");
        Scanner model = new Scanner(System.in);
        String carModel = model.nextLine();

        Car car = new Car(carMaker, carModel);

        cars.add(car);

        System.out.println("New car has been added");
    }

    public void makeBid() {

        System.out.println("Which car to do you want to bid on? ");
        for (int x = 0; x < cars.size(); x++) {
            System.out.println("Car (" + (x + 1) + ") " + cars.get(x).description());
        }
        Scanner carChoice = new Scanner(System.in);
        int carIndex = carChoice.nextInt();


        System.out.println("Please enter your first name: ");
        Scanner firstName = new Scanner(System.in);
        String givenName = firstName.nextLine();

        System.out.println("Please enter your last name: ");
        Scanner lastName = new Scanner(System.in);
        String familyName = lastName.nextLine();

        System.out.println("Please enter your Buyer ID: ");
        Scanner buyerId = new Scanner(System.in);
        int id = buyerId.nextInt();

        Buyer newBuyer = new Buyer(id, givenName, familyName);


        System.out.println("Please enter your bid price: ");
        Scanner price = new Scanner(System.in);
        int bidPrice = price.nextInt();

        System.out.println("Please enter the date: ");
        Scanner givenDate = new Scanner(System.in);
        String date = givenDate.nextLine();


        cars.get(carIndex - 1).addBid(newBuyer, bidPrice, date);

        System.out.println("Your bid has been made");

        }

        public void displayCars() {
            for (int x = 0; x < cars.size(); x++) {
                System.out.println("Car (" + (x + 1) + ") " + cars.get(x).description());
                System.out.print("Bids: ");
                for (int i = 0; i < cars.get(x).bids.size(); i++) {
                    System.out.print("[Bid Id: " + cars.get(x).bids.get(i).getBidId() + ", Buyer:{" + cars.get(x).bids.get
                            (i).getBuyer().description() + "}, ");
                    System.out.print("Price: " + cars.get(x).bids.get(i).getBidPrice() + ", Date: " + cars.get(x).bids.get
                            (i).getBidDate() + "]");

                }
                System.out.println("\n");
            }

        }


    }

















