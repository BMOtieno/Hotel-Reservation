package api;

import api.HotelResource;
import api.AdminMenu;
import model.Customer;

import java.util.Scanner;

public class MainMenu {
    public static void mainMenu(){

        boolean runTask = true;
        try(Scanner scan = new Scanner(System.in)){
            try{
                while(runTask){
                    System.out.println("Welcome to Brian's Hotel Reservation App");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");

                    int select = Integer.parseInt(scan.nextLine());

                    switch (select){
                        case 1:
                            //HotelResource.findARoom();
                            //HotelResource.bookARoom();
                           // runTask = false;
                           // break;

                        case 2:
                            //HotelResource.getCustomerReservations();
                            //runTask = false;
                           // break;

                        case 3:
                           // HotelResource.createACustomer();
                           // runTask = false;
                           // break;

                        case 4:
                            AdminMenu.adminMenu();
                            runTask = false;
                            break;

                        case 5:


                        default:
                            System.out.println("Please enter a number between 1 and 5");
                    }
                }
            }catch(Exception e){
                System.out.println("Error!! Invalid input");

            }

        }
    }
}
