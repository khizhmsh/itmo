package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит элементы, значение поля name которых содержит заданную подстроку
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class FilterContainsName implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.filterContains(request.getArgs());
    }

    @Override
    public String getName() {
        return "filter_contains_name name {element}";
    }

    @Override
    public String getDescription() {
        return "display elements whose name field value contains a substring";
    }
}
