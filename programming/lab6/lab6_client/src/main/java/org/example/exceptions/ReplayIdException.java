package org.example.exceptions;
/**
 * Обеспечивает исключение, если такой ID уже существует
 *
 * @author khizhmsh
 * @since 1.0
 */
public class ReplayIdException extends Exception {
    /**
     * @param id ID которое уже используется
     * @author khizhmsh
     * @since 1.0
     */
    public ReplayIdException(long id) {
        super("ID " + id + " is already used");

    }
}
