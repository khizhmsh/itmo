package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда очищает коллекцию
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ClearCommand implements BaseCommand {

    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.clear(request.getLogin());
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "clear data from table";
    }
}
