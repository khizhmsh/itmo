package managers.commands;

import managers.CollectionManager;
import managers.CommandManager;
import managers.Receiver;

import java.util.HashMap;
/**
 * Данная команда выводит описание всех команд
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class HelpCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.help();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "use this command to see information";
    }
}
