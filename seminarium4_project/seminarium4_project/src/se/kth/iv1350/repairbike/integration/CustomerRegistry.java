package se.kth.iv1350.repairbike.integration;

import se.kth.iv1350.repairbike.exceptions.DatabaseFailureException;
import se.kth.iv1350.repairbike.exceptions.NoSuchCustomerException;
import se.kth.iv1350.repairbike.model.Customer;

public class CustomerRegistry {

    public Customer findCustomer(String phone)
            throws NoSuchCustomerException,
            DatabaseFailureException {

        if (phone.equals("999999999")) {
            throw new DatabaseFailureException(
                    "Could not connect to database.");
        }

        if (phone.equals("0701234567")) {
            return new Customer(
                    "Ali",
                    phone,
                    "ali@mail.com");
        }

        throw new NoSuchCustomerException(phone);
    }
}
