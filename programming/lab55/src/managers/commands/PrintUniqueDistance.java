package managers.commands;

import managers.Receiver;
import resources.Route;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/**
 * Данная команда выводит уникальные значения поля distance всех элементов в коллекции
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class PrintUniqueDistance implements BaseCommand {
    public void execute(String[] args, CollectionManager collectionManager) throws Exception {
        Receiver.printUnique();
    }

    @Override
    public String getName() {
        return "print_unique_distance";
    }

    @Override
    public String getDescription() {
        return "display unique values of the distance field";
    }
}
