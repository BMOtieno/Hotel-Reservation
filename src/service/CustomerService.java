package service;

import model.Customer;

import java.util.*;

public class CustomerService {

    //add new customer
    public static void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        System.out.println("New customer added");
        System.out.println("================================");
        System.out.println(customer);
        System.out.println("================================");
    }

    //method to get customer details through email provided
    public static String getCustomer(String customerEmail){
        Map<String, Customer> data = new HashMap<>();

        for(String email: data.keySet()) {
            if (email.equals(customerEmail)) {
                System.out.println("Retrieved customer details");
                System.out.println("============================");
                System.out.println(data.values());
                System.out.println("============================");
            }
        }
        return "Sorry customer not found";
    }

    //method to search for all customers
    public static Collection<Customer> getAllCustomers(){
        Queue<Customer> getCustomers = new LinkedList<>();

        while(!getCustomers.isEmpty()){
            System.out.println(getCustomers.poll());
        }
       return getCustomers;
    }
}
