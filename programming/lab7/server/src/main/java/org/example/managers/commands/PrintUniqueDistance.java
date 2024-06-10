package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит уникальные значения поля distance всех элементов в коллекции
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class PrintUniqueDistance implements BaseCommand {
    public String execute(Request request, CollectionManager collectionManager) throws Exception {

        return Receiver.printUnique();
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
