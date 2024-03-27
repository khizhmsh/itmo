package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;

import java.util.HashMap;
/**
 * Данная команда удаляет из коллекции все элементы, ключ которых превышает заданный
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveGreaterKey implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.removeGraterKey(args, collectionManager);
    }


    @Override
    public String getName() {
        return "remove_grater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements whose key exceeds the given one";
    }
}
