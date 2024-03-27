package exceptions;
/**
 * Обеспечивает исключение, если не существует элемента в коллекции
 *
 * @see managers.CollectionManager
 * @author khizhmsh
 * @since 1.0
 */
public class NoElementException extends Exception {

    /**
     * Исключение по ключу
     *
     * @param key ключ элемента
     * @author khizhmsh
     * @since 1.0
     */
    public NoElementException(String key) {
        super("No element in collection with key: " + key);
    }
    /**
     * Конструктор с ID
     *
     * @param id ID элемента
     * @author khizhmsh
     * @since 1.0
     */
    public NoElementException(Long id) {
        super("No element in collection with id: " + id);
    }
}
