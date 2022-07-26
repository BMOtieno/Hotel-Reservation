package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    //Apply Singleton design patterns
    private static CustomerService singletonObject = new CustomerService();

    private CustomerService(){

    }

    public static CustomerService getSingletonObject(){
        return singletonObject;
    }
    //Map data structure to hold the list of customers
    Map<String, Customer> listOfCustomers = new HashMap<>();

    //add new customer
    public void addCustomer(String email, String firstName, String lastName){
        listOfCustomers.put(email, new Customer(firstName, lastName, email));
    }

    //method to get customer details through email provided
    public  Customer getCustomer(String customerEmail){
        return listOfCustomers.get(customerEmail);
    }

    //method to search for all customers
    public  Collection<Customer> getAllCustomers(){
        return listOfCustomers.values();
    }
}
