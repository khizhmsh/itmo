package exceptions;
/**
 * Обеспечивает исключение, если возникла ошибка при создании объекта класса Organization
 *
 * @see resources.Route
 * @author khizhmsh
 * @since 1.0
 */
public class BuildRouteException extends Exception {
    /**
     * @param message сообщение, которое необходимо вывести
     * @author khizhmsh
     * @since 1.0
     */
    public BuildRouteException(String message) {
        super(message);
    }


}
