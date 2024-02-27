package managers.commands;

import managers.CollectionManager;

public class ClearCommand implements BaseCommand {

    @Override
    public void execute(String[] args) throws Exception {
        CollectionManager.getMap().clear();
        System.out.println("Map is clear");
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
