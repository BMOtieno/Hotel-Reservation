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

        Customer customer = new Customer();
        customer.setEmail(customerEmail);
        customer.getEmail();

        return customer.getFirstName();

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
