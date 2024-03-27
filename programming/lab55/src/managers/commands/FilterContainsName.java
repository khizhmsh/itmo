package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;

import java.util.HashMap;
/**
 * Данная команда выводит элементы, значение поля name которых содержит заданную подстроку
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class FilterContainsName implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.filterContains(args);
    }

    @Override
    public String getName() {
        return "filter_name";
    }

    @Override
    public String getDescription() {
        return "display elements whose name field value contains a substring";
    }
}
