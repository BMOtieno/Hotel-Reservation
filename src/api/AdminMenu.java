package api;

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
                    System.out.println("Back to the Main Menu");
                    int choice = Integer.parseInt(scanner.nextLine());

                    if(choice == 1){
                        System.out.println("1");
                        runProcess = false;
                    }else if(choice == 2){
                        System.out.println("2");
                        runProcess = false;
                    }else if(choice == 3){
                        System.out.println("3");
                        runProcess = false;
                    }else if(choice == 4){
                        System.out.println("4");
                        runProcess = false;
                    }else{
                        System.out.println("The number should be between 1 and 4. Please try again");
                    }
                }catch (Exception e){
                    System.out.println("Error!!! You have entered an invalid input");

                }
            }
        }
    }
}
