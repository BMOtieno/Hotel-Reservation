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
                            System.out.println("Enter CheckIn Date mm/dd/yy example 02/01/2020");

                            System.out.println("Enter checkOut Date month/day/year example 2/21/2020");

                            System.out.println("Would you like to book a room? y/n");

                            System.out.println("Do you have an account with us? y/n");

                            System.out.println("Enter Email format: name@domain.com");

                            System.out.println("What room would you like to reserve? ");
                            //HotelResource.findARoom();
                            //HotelResource.bookARoom();

                             break;

                        case 2:
                            System.out.println("Enter Email format: name@domain.com");
                            String emailCustomer = scan.nextLine();
                            HotelResource.getCustomerReservations(emailCustomer);
                            break;

                        case 3:
                            System.out.println("Enter Email format: name@domain.com");
                            String email = scan.nextLine();
                            System.out.println("First name:");
                            String fName = scan.nextLine();
                            System.out.println("Last Name:");
                            String lName = scan.nextLine();
                            HotelResource.createACustomer(email, fName, lName);
                            break;

                        case 4:
                            AdminMenu.adminMenu();
                            runTask = false;
                            break;

                        case 5:
                            System.out.println("Good bye");
                            runTask = false;
                            break;

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
