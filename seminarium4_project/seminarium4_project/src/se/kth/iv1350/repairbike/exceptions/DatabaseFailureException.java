package se.kth.iv1350.repairbike.exceptions;

/**
 * Thrown when database can not be reached.
 */
public class DatabaseFailureException extends Exception {

    public DatabaseFailureException(String message) {
        super(message);
    }
}
