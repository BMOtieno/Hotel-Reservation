package model;

/**
 * Program for setting up customer accounts.
 * @author Brian Odhiambo
 * @param first name, last name and email of the customer using the app.
 * @return result returns the name and email address of the account user
 */

import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;

    String emailRegex = "^(.+)@(.+).com$"; // regex to validate the email string
    Pattern pattern = Pattern.compile(emailRegex);

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

        //used to check that the email is in the correct format
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Email address provided is not in the correct format");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "FirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nEmail: " + email;
    }
}
