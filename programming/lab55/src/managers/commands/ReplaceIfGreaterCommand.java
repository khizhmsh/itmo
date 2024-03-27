package managers.commands;

import managers.Receiver;
import resources.Route;
import resources.comparators.RouteDisComparator;
import resources.generators.RouteGenerator;
import managers.CollectionManager;

import java.util.HashMap;
/**
 * Данная команда заменяет значение по ключу, если новое значение больше старого
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ReplaceIfGreaterCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.replace(args, collectionManager);
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }

}
