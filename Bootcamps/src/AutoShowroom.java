import java.util.ArrayList;

public class AutoShowroom {

//    Car[] cars = new Car[3];
    ArrayList<Car> cars = new ArrayList<Car>();

    public void printStatus(){
        System.out.println("Welcome to FIT2099 Showroom");
        createCars();
        displayCars();
        System.out.println("Thank you for visiting FIT2099 Showroom");

    }

    public void createCars(){

        Car car1 = new Car("BMW","X7");
        Car car2 = new Car("Audi","A8");
        Car car3 = new Car("Mercedes","GLS");

//        cars[0] = car1;
//        cars[1] = car2;
//        cars[2] = car3;

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

    }

    public void displayCars(){
        for (int x= 0;x < cars.size(); x++){
            System.out.println("Car ("+ (x+1) + ") " + cars.get(x).description());
        }
    }

}
