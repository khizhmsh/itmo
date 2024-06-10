package org.example.managers.commands;

import org.example.network.Request;
import org.example.managers.CollectionManager;
import org.example.managers.Receiver;

/**
 * Данная команда выводит описание всех команд
 *
 * @see BaseCommand
 * @author khizhmsh
 * @since 1.0
 */
public class HelpCommand implements BaseCommand {
    @Override
    public String execute(Request request, CollectionManager collectionManager) throws Exception {

        return Receiver.help();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "use this command to see information";
    }
}
