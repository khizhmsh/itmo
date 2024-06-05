package org.example.exceptions;
/**
 * Обеспечивает исключение, если такой команды уже существует
 *
 * @author khizhmsh
 * @since 1.0
 */
public class UnknownCommandException extends Exception {
    /**
     * @param command неизвестная команда
     * @author khizhmsh
     * @since 1.0
     */
    public UnknownCommandException(String command) {
        super("Unknown command: " + command);
    }

}
