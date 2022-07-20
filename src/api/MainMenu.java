package api;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args){

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

                    if(select == 1){
                        System.out.println();
                        runTask = false;
                    }else if(select == 2){
                        System.out.println();
                        runTask = false;
                    }else if(select == 3){
                        System.out.println();
                        runTask = false;
                    }else if(select == 4){
                        System.out.println();
                        runTask = false;
                    }else if(select == 5){
                        System.out.println("Have a great day");
                        runTask = false;
                    }else{
                        System.out.println("Please select numbers between 1 and 5");
                    }
                }
            }catch(Exception e){
                System.out.println("Error!! Invalid input");

            }

        }
    }
}
