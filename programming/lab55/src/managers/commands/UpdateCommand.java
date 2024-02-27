package managers.commands;

import data.Route;
import exceptions.NoElementException;
import generators.RouteGenerator;
import managers.CollectionManager;

public class UpdateCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        System.out.println("Start executing command...");

        boolean elementInCollection = false;
        Long id = Long.parseLong(args[1]);

        for (String key : CollectionManager.getMap().keySet()) {
            if (CollectionManager.getMap().get(key).getId().equals(id)) {
                System.out.println("Updating element with id " + args[1]);
                elementInCollection = true;

                Route route = RouteGenerator.createRoute(id);
                CollectionManager.remove(key);
                CollectionManager.add(key, route);

                System.out.println("Element was updated");
            }
        }
        if (!elementInCollection) {
            throw new NoElementException(id);
        }
    }

    @Override
    public String getName() {
        return "update id {element}";
    }

    @Override
    public String getDescription() {
        return "update element";
    }
}
