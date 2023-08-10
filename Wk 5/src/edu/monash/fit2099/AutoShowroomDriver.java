package edu.monash.fit2099;

import edu.monash.fit2099.exceptions.BidException;
import edu.monash.fit2099.exceptions.SedanException;
import edu.monash.fit2099.exceptions.TruckException;
import edu.monash.fit2099.exceptions.VehicleException;

import java.util.Scanner;

public class AutoShowroomDriver {
    public static void main(String[] args) throws SedanException, TruckException,VehicleException, BidException {
       AutoShowroom Showroom1  = new AutoShowroom();
//       Showroom1.printStatus();

        int selection;
        do{
            selection = selectMenuItem();
            switch (selection) {
                case 1 -> Showroom1.createSedan();
                case 2 -> Showroom1.createTruck();
                case 3 -> Showroom1.displayFleet();
                case 4 -> Showroom1.createBuyer();
                case 5 -> Showroom1.displayBuyers();
                case 6 -> Showroom1.createBid();
                case 7 -> Showroom1.highestBid();
                case 8 -> Showroom1.lowestBid();
                case 9 -> Showroom1.deleteBid();
            }
        }while (selection <10);



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
        System.out.println("7) List Highest Bid ");
        System.out.println("8) List Lowest Bid ");
        System.out.println("9) Delete Bid ");
        System.out.println("10) Exit ");
        System.out.println();
        System.out.println("_______________________");
        return scanner.nextInt();


    }



}
