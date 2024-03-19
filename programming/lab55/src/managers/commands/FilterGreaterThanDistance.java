package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;

import java.util.HashMap;
/**
 * Данная команда выводит элементы, значение поля distance которых больше заданного
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class FilterGreaterThanDistance implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.filterGreater(args);
    }

    @Override
    public String getName() {
        return "filter_greater_than_distance distance{element}";
    }

    @Override
    public String getDescription() {
        return "display elements whose distance field value is greater than a given one";
    }

}
