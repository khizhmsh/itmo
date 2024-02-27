package managers;

import exceptions.UnknownCommandException;
import managers.commands.*;

import java.util.HashMap;

public class CommandManager {
    private static HashMap<String, BaseCommand> commandList;

    public CommandManager() {
        commandList = new HashMap<>();
        commandList.put("help", new HelpCommand());
        commandList.put("info", new InfoCommand());
        commandList.put("show", new ShowCommand());
        commandList.put("insert", new InsertCommand());
        commandList.put("update", new UpdateCommand());
        commandList.put("remove_key", new RemoveCommand());
        commandList.put("clear", new ClearCommand());
        commandList.put("save", new SaveXMLCommand());
        commandList.put("execute_script", new ExecuteScriptCommand());
        commandList.put("exit", new ExitCommand());
        commandList.put("remove_greater", new RemoveGraterCommand());
        commandList.put("replace_if_grater", new ReplaceIfGreaterCommand());
        commandList.put("remove_greater_key", new RemoveGreaterKey());
        commandList.put("filter_contains_name", new FilterContainsName());
        commandList.put("filter_greater_than_distance", new FilterGreaterThanDistance());
        commandList.put("print_unique_distance ", new PrintUniqueDistance());

    }

    public static void startExecuting(String line) throws Exception {
        String commandName = line.split(" ")[0];
        if (!commandList.containsKey(commandName)) {
            throw new UnknownCommandException(commandName);
        }
        BaseCommand command = commandList.get(commandName);
        command.execute(line.split(" "));
    }

    public HashMap<String, BaseCommand> getCommandList() {
        return commandList;
    }
}
