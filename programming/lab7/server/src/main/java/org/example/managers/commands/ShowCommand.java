package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит список всех команд
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class ShowCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {
        return Receiver.show();
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public String getDescription() {
        return "show data";
    }

}
