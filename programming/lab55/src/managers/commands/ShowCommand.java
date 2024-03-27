package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;

import java.util.HashMap;
/**
 * Данная команда выводит список всех команд
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.show();
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show data";
    }

}
