package exceptions;
/**
 * Обеспечивает исключение, если такой возникла ошибка с аргументом
 *
 * @author khizhmsh
 * @since 1.0
 */

public class WrongArgumentException extends Exception {
    /**
     * @param argument название аргумента, который был введен неправильно
     * @author khizhmsh
     * @since 1.0
     */
    public WrongArgumentException(String argument) {
        super("Something wrong with input argument: " + argument);
    }

}
