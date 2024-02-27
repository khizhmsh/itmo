package managers.commands;

import managers.CommandManager;

import java.util.HashMap;

public class HelpCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        CommandManager commandManager = new CommandManager();
        HashMap<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
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
