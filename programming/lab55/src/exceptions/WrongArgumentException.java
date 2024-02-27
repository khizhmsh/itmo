package exceptions;

public class WrongArgumentException extends Exception {
    public WrongArgumentException(String argument) {
        super("Something wrong with input argument: " + argument);
    }

}
