package managers;

import java.io.InputStream;
import java.util.Scanner;
/**
 * Данный класс отвечает за чтение командной строки
 * Обеспечивает связь между пользователем и командами (CommandManager)
 *
 * @see CommandManager
 * @author khizhmsh
 * @since 1.0
 */

public class Console {
    public static String data_path ;
    /**
     * Требуется передать значение переменной окружения файла XML, в котором хранятся данные
     * Начните выполнять команды из InputStream
     *
     * @param in откуда происходит чтение
     */

    public void start(InputStream in, CollectionManager collectionManager) throws Exception {
        Scanner sc = new Scanner(in);
        CommandManager commandManager = new CommandManager();
        data_path = System.getenv().get("lab5");
        FileManager.read(collectionManager);

        while (sc.hasNextLine()) {
            try {
                String line = sc.nextLine();
                commandManager.startExecuting(line, collectionManager);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
