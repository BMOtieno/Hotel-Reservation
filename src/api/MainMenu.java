package api;

import model.Reservation;
import model.IRoom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {

    private static final String DATE_FORMAT = "MM/dd/yyyy";
    //Singleton Objects from HotelResource and AdminResource classes
    public static HotelResource hotelResourceObject = HotelResource.getHotelResourceSingletonObject();
    public static AdminResource adminResourceObject = AdminResource.getAdminResourceObject();

    public static void mainMenu(){
        boolean runTask = true;
        //placing the scanner object in the try catch is an effective way to ensure resources are closed after program stops running
        try(Scanner scan = new Scanner(System.in)){
            while(runTask){
                try{
                    System.out.println("----------------------------------------------");
                    System.out.println("Welcome to Brian's Hotel Reservation App");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservations");
                    System.out.println("3. Create an account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    System.out.println("-----------------------------------------------");

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
                            System.exit(0);

                        default:
                            System.out.println("Please enter a number between 1 and 5");
                    }
                }catch(Exception e){
                    System.out.println("Invalid Input");
                }
            }
        }
    }

    //method for finding and reserving a room
    public static void findAndReserveARoom() throws ParseException {
        Scanner scanned = new Scanner(System.in);

        //find a room
        System.out.println("Enter CheckIn Date mm/dd/yyyy example 02/13/2020"); //enter checkIn date
        String dateInputOne = scanned.nextLine();
        Date date = new SimpleDateFormat(DATE_FORMAT).parse(dateInputOne);

        System.out.println("Enter CheckOut Date mm/dd/yyyy example 10/21/2020"); //enter checkOut date
        String dateInputTwo = scanned.nextLine();
        Date dateTwo = new SimpleDateFormat(DATE_FORMAT).parse(dateInputTwo);

        if(date != null && dateTwo != null){
            Collection<IRoom> availableRooms = hotelResourceObject.findARoom(date,dateTwo);

           if(availableRooms.isEmpty()){
               Collection<IRoom> otherRooms = hotelResourceObject.findAlternativeRooms(date, dateTwo);

               if(otherRooms.isEmpty()) {
                   System.out.println("Room not found");
               }
           }
        }
        System.out.println("-------------------------------------------");
        System.out.println("Rooms currently listed");
        System.out.println("-------------------------------------------");
        System.out.println(adminResourceObject.getAllRooms());
        System.out.println("-------------------------------------------");

        //book a room
        System.out.println("Would you like to book a room? y/n");
        String response = scanned.nextLine();

        if(response.equalsIgnoreCase("y")){
            System.out.println("Do you have an account with us? y/n");
            String accountOpened = scanned.nextLine();
            if(accountOpened.equalsIgnoreCase("y")){
                System.out.println("Please enter your email. Email format name@domain.com");
                String customerEmail = scanned.nextLine();

                if(adminResourceObject.getCustomer(customerEmail) == null){
                    System.out.println("Customer not found. Please create an account");
                }else{
                    System.out.println("What room would you would like to reserve");
                    String reservedRoomNumber = scanned.nextLine();

                    Collection<IRoom> allRoomsReserved = adminResourceObject.getAllRooms();
                    IRoom room = hotelResourceObject.getRoom(reservedRoomNumber);

                    if(allRoomsReserved.contains(room)){
                        Reservation reservation = hotelResourceObject.bookARoom(customerEmail, room, date, dateTwo);
                        System.out.println("Reservations made successfully");
                        System.out.println(reservation);
                        allRoomsReserved.remove(room);
                    }else{
                        System.out.println("This room is already reserved");
                        Date possibleCheckIn = hotelResourceObject.addDefaultDays(date);
                        Date possibleCheckOut = hotelResourceObject.addDefaultDays(dateTwo);
                        System.out.println("Recommended rooms on alternative dates:" +
                                "\nCheckIn Date: " + possibleCheckIn +
                                "\nCheckOut Date: " + possibleCheckOut);

                        System.out.println("Enter new room [type 'x' to skip]:");
                        String recommendedRoom = scanned.nextLine();
                        IRoom roomObject = hotelResourceObject.getRoom(recommendedRoom);
                        System.out.println("Enter your email [type 'x' to skip]. Email format name@domain.com");
                        String customerAlternativeEmail = scanned.nextLine();

                        if(recommendedRoom.equalsIgnoreCase("x") && customerAlternativeEmail.equalsIgnoreCase("x")){
                            System.out.println("Process terminated...returning to the main menu");
                        }else{
                            Reservation possibleReservation = hotelResourceObject.bookARoom(customerAlternativeEmail, roomObject, possibleCheckIn, possibleCheckOut);
                            System.out.println("Successfully made a Reservation");
                            System.out.println("====================================================");
                            System.out.println(possibleReservation);
                            System.out.println("====================================================");
                        }
                    }
                    mainMenu();
                }

            }else if(accountOpened.equalsIgnoreCase("n")){
                mainMenu();
            }else{
                System.out.println("Please select either Y for Yes or N for No");
            }
        }else if(response.equalsIgnoreCase("n")){
            mainMenu();
        }else{
            System.out.println("Please select either Y for Yes or N for No");
        }
    }

    //method to view customer's reservations
    public static void seeMyReservations(){

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your email: Use the format name@domain.com");
        String clientEmail = scan.nextLine();

        System.out.println(hotelResourceObject.getCustomerReservations(clientEmail));
    }

    //method to create a customer account
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
