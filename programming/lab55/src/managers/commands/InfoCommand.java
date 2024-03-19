package managers.commands;

import managers.CollectionManager;
import managers.Receiver;

/**
 * Данная команда выводит данные о программе
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class InfoCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        if (args.length != 1){
            System.out.println("Wrong command argument");
            return;
        }
        Receiver.info();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public String getDescription() {
        return "information about app";
    }
}


