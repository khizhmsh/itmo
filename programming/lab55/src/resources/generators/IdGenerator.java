package resources.generators;

import java.util.ArrayList;
/**
 * Класс генерирует ID для объекта Route
 *
 * @author khizhmsh
 * @see resources.Route
 * @since 1.0
 */

public class IdGenerator {
    private static final Integer min = 1000000;
    private static final Integer max = 10000000;
    private static ArrayList<Long> IdList = new ArrayList<>();
    /**
     * Базовый конструктор
     *
     * @author khizhmsh
     * @since 1.0
     */

    public IdGenerator() {
        IdList = new ArrayList<>();
    }
    /**
     * Метод генерирует новый уникальный ID
     *
     * @author khizhmsh
     * @since 1.0
     */

    public static Long generateId() {
        Long id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        while (IdList.contains(id)) {
            id = (long) Math.floor(Math.random() * (max - min + 1)) + min;
        }
        IdList.add(id);
        return id;
    }
    /**
     * Метод проверяет ID на уникальность
     *
     * @param id какой id нужно проверить на уникальность
     * @author khizhmsh
     * @since 1.0
     */

    public static boolean idIsUnique(long id) {
        if (IdList.contains(id)) {
            return false;
        }
        return true;
    }
    /**
     * Добавляет ID в список
     *
     * @param id какой id нужно добавить
     * @author khizhmsh
     * @since 1.0
     */

    public static void add(long id) {
        IdList.add(id);
    }
    /**
     * Удаляет ID из списка
     *
     * @param id какой id нужно удалить
     * @author khizhmsh
     * @since 1.0
     */
    public static void remove(long id) {
        IdList.remove(id);
    }
}
