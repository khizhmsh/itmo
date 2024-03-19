package system;


import managers.CollectionManager;
import managers.Console;
import resources.Route;
import resources.generators.RouteGenerator;

/**
 * Главный класс, который запускает программу.
 *
 *
 * @author khizhmsh
 * @since 1.0
 */

public class Main {
    /**
     * Точка начала программы.
     *
     * @param args аргументы из командной строки
     */
    public static void main(String[] args) throws Exception {
        Console console = new Console();
        CollectionManager collectionManager = new CollectionManager();
        console.start(System.in, collectionManager);
        System.out.println();


    }
}