package org.example.managers;


import org.example.network.Request;
import org.example.exceptions.UnknownCommandException;
import org.example.managers.commands.*;

import java.util.HashMap;

/**
 * Данный класс обеспечивает связь между командами и CollectionManager
 *
 * @author khizhmsh
 * @see CollectionManager
 * @since 1.0
 */

public class CommandManager {
    private static HashMap<String, BaseCommand> commandList;

    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("login", new LoginCommand());
        commandList.put("reg", new RegisterCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("insert", new InsertCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove_key", new RemoveCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("remove_greater", new RemoveGraterCommand());
        commandList.put("replace_if_greater", new ReplaceIfGreaterCommand());
        commandList.put("remove_greater_key", new RemoveGreaterKey());
        commandList.put("filter_contains_name", new FilterContainsName());
        commandList.put("filter_greater_than_distance", new FilterGreaterThanDistance());
        commandList.put("print_unique_distance", new PrintUniqueDistance());

    }

    public static String startExecuting(Request request, CollectionManager collectionManager) throws Exception {
        String commandName = request.getNameCommand();
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
        }
        BaseCommand command = commandList.get(commandName);
        return command.execute(request, collectionManager);
    }

    public HashMap<String, BaseCommand> getCommandList() {
        return commandList;
    }
}
