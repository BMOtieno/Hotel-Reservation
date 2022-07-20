package service;

import model.Customer;

import java.util.*;

public class CustomerService {
    public static void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        List<Customer> addingCustomer = new ArrayList<>();
        addingCustomer.add(customer);
        System.out.println(customer + " has been added");

    }
    public static String getCustomer(String customerEmail){

        Map<String, Customer> data = new HashMap<>();
        ArrayList<Customer> person = new ArrayList<>();

        for(Customer customerList: person){
            add(data, customerList);
            if(customerEmail.equals(data.keySet())){
                System.out.println(customerList);
            }
        }
        return "Customer not found by the provided email. Try again.";
    }
    public static Collection<Customer> getAllCustomers(){

        Queue<Customer> getCustomers = new LinkedList<>();

        while(!getCustomers.isEmpty()){
            System.out.println("Customer " + getCustomers.poll() + " has signed up");
        }
       return getCustomers;
    }

    public static void add(Map<String, Customer> map, Customer customer){
        map.put(customer.getEmail(), customer);
    }

}
