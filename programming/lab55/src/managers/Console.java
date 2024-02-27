package managers;


import java.io.InputStream;
import java.util.Scanner;

import static system.ReaderXML.read;

public class Console {
    public static String data_path = "C:/Users/user/OneDrive/Рабочий стол/ITMO/Programming/Labs/lab55/src/system/data.xml";

    public void start(InputStream in) throws Exception {
        Scanner sc = new Scanner(in);
        CommandManager commandManager = new CommandManager();
        new CollectionManager();
        read(System.getenv().get("lab5"), true);
        while (sc.hasNextLine()) {
            try {
                String line = sc.nextLine();
                commandManager.startExecuting(line);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
