package api;

import api.AdminResource;
import api.MainMenu;

import java.util.Scanner;

public class AdminMenu {
    public static void adminMenu(){
        boolean runProcess = true;
        try(Scanner scanner = new Scanner(System.in)){

            while(runProcess){
                try{
                    System.out.println("Welcome to the Admin Dashboard");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to the Main Menu");
                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice){
                        case 1:
                            AdminResource.getAllCustomers();
                            runProcess = false;
                            break;

                        case 2:
                            AdminResource.getAllRooms();
                            runProcess = false;
                            break;

                        case 3:
                            AdminResource.displayAllReservations();
                            runProcess = false;
                            break;

                        case 4:
                            System.out.println("Enter room number");


                        case 5:
                            MainMenu.mainMenu();
                            runProcess = false;
                            break;

                        default:
                            System.out.println("Select a number between 1 and 5. Please try again.");
                    }
                }catch (Exception e){
                    System.out.println("Error!!! You have entered an invalid input");

                }
            }
        }
    }
}
