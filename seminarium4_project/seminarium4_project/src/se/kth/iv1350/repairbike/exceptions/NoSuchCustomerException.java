package se.kth.iv1350.repairbike.exceptions;

/**
 * Thrown when customer does not exist.
 */
public class NoSuchCustomerException extends Exception {

    public NoSuchCustomerException(String phone) {
        super("No customer found with phone number: " + phone);
    }
}
