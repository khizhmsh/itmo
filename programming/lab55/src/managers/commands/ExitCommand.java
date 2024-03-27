package managers.commands;

import managers.CollectionManager;
import managers.Receiver;

/**
 * Данная команда завершает программу без сохранения коллекции
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ExitCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) {
        Receiver.exitCommand();
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "close command without save";
    }
}

