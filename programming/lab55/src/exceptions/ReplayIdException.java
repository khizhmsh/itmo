package exceptions;

public class ReplayIdException extends Exception {
    public ReplayIdException(long id) {
        super("ID " + id + " is already used");

    }
}
