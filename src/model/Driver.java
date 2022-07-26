package model;

/**
 * Customer tester class
 * @author Brian Odhiambo
 */

public class Driver {
    public static void main(String[] args){
        Customer customer = new Customer("Jay","Cee", "j@domain.com");
        System.out.println(customer);

        //string array of email addresses
       String[] secondCustomers = new String[] {"otieno@gmail.com", "email", "owino@gmail.com"};

       for(int i = 0; i < secondCustomers.length; i++){
           try{
               System.out.println(new Customer("JokaMama", "Hannah",secondCustomers[i]));
           }catch(IllegalArgumentException e){
               System.out.println(e.getLocalizedMessage());
           }
       }
    }
}
