package api;

import model.Reservation;
import model.IRoom;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {

    public static HotelResource hotelResourceObject = HotelResource.getHotelResourceSingletonObject();
    public static AdminResource adminResourceObject = AdminResource.getAdminResourceObject();

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
                            findAndReserveARoom();
                            break;

                        case 2:
                            seeMyReservations();
                            break;

                        case 3:
                            createAnAccount();
                            break;

                        case 4:
                            AdminMenu.adminMenu();
                            break;

                        case 5:
                            System.out.println("Good bye");
                            runTask = false;
                            break;

                        default:
                            System.out.println("Please enter a number between 1 and 5");
                            break;
                    }
                }
            }catch(Exception e){
                System.out.println("Error!! Invalid input");
            }
        }
    }

    public static void findAndReserveARoom() throws ParseException {
        Scanner scanned = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("mm/dd/yyyy");

        //find a room
        System.out.println("Enter CheckIn Date mm/dd/yy example 02/13/2020");
        String dateInputOne = scanned.nextLine();
        Date date =  format.parse(dateInputOne);

        System.out.println("Enter CheckOut Date mm/dd/yy example 10/21/2020");
        String dateInputTwo = scanned.nextLine();
        Date dateTwo =  format.parse(dateInputTwo);

        if(date != null && dateTwo != null){
            hotelResourceObject.findARoom(date, dateTwo);
        }else{
            adminResourceObject.getAllRooms();
        }

        //book a room
        System.out.println("Would you like to book a room? y/n");
        String response = scanned.next();

        if(response.equals("y")){
            System.out.println("Do you have an Account already opened? y/n");
            String accountOpened = scanned.next();
            if(accountOpened.equals("y")){
                System.out.println("Please enter your email. Email format name@domain.com");
                String customerEmail = scanned.nextLine();

                if(hotelResourceObject.getCustomer(customerEmail) == null){
                    System.out.println("User not found. \nCreate an account to book a room");
                    createAnAccount();
                }else{
                    System.out.println("Enter the room number you would like to reserve");
                    String reservedRoomNumber = scanned.nextLine();
                    IRoom room = hotelResourceObject.getRoom(reservedRoomNumber);
                    Reservation reservation = hotelResourceObject.bookARoom(customerEmail, room, date, dateTwo);
                    System.out.println("Reservations made successfully");
                    System.out.println(reservation);
                }
            }else{
                System.out.println("Please create an account");
                createAnAccount();
            }
        }else{
            System.out.println("You need an account to be able to book a room");
            createAnAccount();
        }
    }

    public static void seeMyReservations(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your email: Use the format name@domain.com");
        String clientEmail = scan.nextLine();

        hotelResourceObject.getCustomerReservations(clientEmail);
    }

    public static void createAnAccount(){
        Scanner scannerInput = new Scanner(System.in);

        System.out.println("Enter Email: Use Format name@domain.com");
        String userEmail = scannerInput.nextLine();

        System.out.println("First name:");
        String userFirstName = scannerInput.nextLine();

        System.out.println("Last name:");
        String userLastName = scannerInput.nextLine();

        hotelResourceObject.createACustomer(userEmail, userFirstName, userLastName);
        System.out.println("Account created successfully");

        mainMenu();
    }
}
