package api;

import model.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class AdminMenu {
    //AdminResource Singleton Object created
    private static AdminResource adminResourceSingletonObject = AdminResource.getAdminResourceObject();

    public static void adminMenu(){
        boolean runProcess = true;
        try(Scanner scanner = new Scanner(System.in)){
            while(runProcess){
                try{
                    System.out.println("------------------------------------------");
                    System.out.println("Welcome to the Admin Dashboard");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to the Main Menu");
                    System.out.println("-------------------------------------------");

                    int choice = Integer.parseInt(scanner.nextLine());

                    switch (choice){
                        case 1:
                            seeAllCustomers();
                            break;

                        case 2:
                            seeAllRooms();
                            break;

                        case 3:
                            seeAllReservations();
                            break;

                        case 4:
                            addARoom();
                            break;

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

    public static void seeAllCustomers(){
        Collection<Customer> allCustomers = adminResourceSingletonObject.getAllCustomers();

        if(allCustomers.isEmpty()){
            System.out.println("No customers present in the system");
        }else{
            for(Customer customer: allCustomers){
                System.out.println(customer);
            }
        }
    }

    public static void seeAllRooms(){
        Collection<IRoom> allRooms = adminResourceSingletonObject.getAllRooms();

        if(allRooms.isEmpty()){
            System.out.println("No available rooms found");
        }else{
            for(IRoom room: allRooms){
                System.out.println(room);
            }
        }
    }

    public static void seeAllReservations(){
        adminResourceSingletonObject.displayAllReservations();
    }

    public static void addARoom() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter room number: ");
        String roomNumber = userInput.nextLine();

        System.out.println("Enter price per night: ");
        double pricePerNight = userInput.nextDouble();

        System.out.println("Enter room type: 1. Single bed,  2. Double bed");
        int option = userInput.nextInt();
        RoomType roomType = RoomType.getTypeByOrdinal(option);
        RoomType roomType2  = RoomType.getTypeByOrdinal(option);

        if (roomType == RoomType.SINGLE) {
            System.out.println(roomType);
        } else if (roomType2 == RoomType.DOUBLE) {
            System.out.println(roomType2);
        } else {
            System.out.println("Please select between option 1 and option 2");
        }

        Room finalRoom = new Room(roomNumber, pricePerNight, roomType);
        adminResourceSingletonObject.addRoom(Collections.singletonList(finalRoom));
        System.out.println("The room was successfully added");

        System.out.println("Would you like to add another room? y/n");
        String anotherRoom = userInput.next();

        while ((!anotherRoom.equals("y") && !anotherRoom.equals("n")) || anotherRoom.length() != 1) {
            System.out.println("Please enter Y for Yes or N for No");
            anotherRoom = userInput.next();
        }
        if (anotherRoom.equals("y")) {
            addARoom();
        } else if (anotherRoom.equals("n")) {
            adminMenu();
        } else {
            addARoom();
        }
    }
}

