package managers.commands;

import exceptions.NoElementException;
import managers.CollectionManager;

public class RemoveCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Start executing command...");
        try {
            CollectionManager.remove(args[1]);
            System.out.println("Element was removed");
        } catch (NoElementException e) {
            System.out.println(e.getMessage());
            System.out.println("Program was returned to safe state");
        }
    }

    @Override
    public String getName() {
        return "remove_key null";
    }

    @Override
    public String getDescription() {
        return "remove_key element by key";
    }

}
