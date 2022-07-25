package api;

import api.AdminResource;
import api.MainMenu;
import model.IRoom;
import model.Reservation;
import model.Room;
import model.RoomType;

import java.util.ArrayList;
import java.util.List;
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
                            break;

                        case 2:
                            AdminResource.getAllRooms();
                            break;

                        case 3:
                            AdminResource.displayAllReservations();
                            break;

                        case 4:
                            System.out.println("Enter room number");
                            String roomNumber = scanner.nextLine();
                            Room roomOne = new Room();
                            roomOne.setRoomNumber(roomNumber);
                            List<IRoom> room = new ArrayList<>();
                            room.add(roomOne);
                            AdminResource.addRoom(room);

                            System.out.println("Enter price per night");
                            double price = scanner.nextDouble();
                            Room roomTwo = new Room();
                            roomTwo.setRoomPrice(price);
                            System.out.println("price set at: " + roomTwo.getRoomPrice());

                            System.out.println("Enter room type: 1.for Single bed,  2.for double bed");
                            int option = scanner.nextInt();
                            if(option == 1){
                                RoomType myRoom = RoomType.SINGLE;
                                System.out.println(myRoom);
                            }else if(option == 2){
                                RoomType myRoom2 = RoomType.DOUBLE;
                                System.out.println(myRoom2);
                            }else {
                                System.out.println("Please select between 1 and 2");
                            }

                            System.out.println("Would you like to add another room? y/n");
                            String response = scanner.next();
                            if(response.equals("y")){
                                adminMenu();
                            }else if(response.equals("n")){
                                MainMenu.mainMenu();
                            }else{
                                System.out.println("Please enter Y( Yes) or N (no)");
                            }
                            runProcess = false;
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
}
