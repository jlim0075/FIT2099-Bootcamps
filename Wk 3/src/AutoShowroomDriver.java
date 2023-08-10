import java.util.Scanner;

public class AutoShowroomDriver {
    public static void main(String[] args) {
       AutoShowroom Showroom1  = new AutoShowroom();

       int selection;
       do{
           selection = selectMenuItem();
           switch (selection){
               case 1:
                   Showroom1.createCars();
                   break;
               case 2:
                   Showroom1.printStatus();
                   break;
               case 3:
                   Showroom1.makeBid();

           }
       }while (selection <4);
    }


    public static int selectMenuItem(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------");
        System.out.println("| Bootcamp Week 3 |");
        System.out.println("-------------------");
        System.out.println("1) New Car ");
        System.out.println("2) List Car(s) ");
        System.out.println("3) New Bid(s) ");
        System.out.println("4) Exit ");
        System.out.println();
        System.out.println("_______________________");
        int choice =scanner.nextInt();
        return choice;


    }

}
