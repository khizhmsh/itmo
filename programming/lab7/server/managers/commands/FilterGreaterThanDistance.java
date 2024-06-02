package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит элементы, значение поля distance которых больше заданного
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class FilterGreaterThanDistance implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.filterGreater(request.getArgs());
    }

    @Override
    public String getName() {
        return "filter_greater_than_distance distance ";
    }

    @Override
    public String getDescription() {
        return "display elements whose distance field value is greater than a given one";
    }

}
