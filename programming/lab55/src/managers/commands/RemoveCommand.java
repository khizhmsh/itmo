package managers.commands;

import exceptions.NoElementException;
import managers.CollectionManager;
import managers.Receiver;

/**
 * Данная команда удаляет из коллекции элемент по ключу
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.removeCommand(args, collectionManager);
    }

    @Override
    public String getName() {
        return "remove_key null";
    }

    @Override
    public String getDescription() {
        return "remove_key element by key";
    }

}
