package managers.commands;


import managers.Receiver;
import resources.Route;
import resources.comparators.RouteDisComparator;
import resources.comparators.RouteNameComparator;
import resources.generators.RouteGenerator;
import managers.CollectionManager;

import java.util.ArrayList;
import java.util.HashMap;
/**
 * Данная команда удаляет из коллекции все элементы, превышающие заданный
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class RemoveGraterCommand implements BaseCommand {
    @Override
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.removeGraterCommand(collectionManager);
    }

    @Override
    public String getName() {
        return "remove_grater {element}";
    }

    @Override
    public String getDescription() {
        return "remove elements with grater than the element";
    }


}

