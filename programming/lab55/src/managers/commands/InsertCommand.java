package managers.commands;

import data.Route;
import exceptions.BuildRouteException;
import exceptions.WrongArgumentException;
import generators.RouteGenerator;
import managers.CollectionManager;

public class InsertCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws WrongArgumentException {
        System.out.println("Start executing command...");
        if (args.length == 2 && !CollectionManager.getMap().containsKey(args[1])) {
            try {
                Route route = RouteGenerator.createRoute(0L);
                CollectionManager.add(args[1], route);
                System.out.println("Element was added");
            } catch (WrongArgumentException e) {
                System.out.println(e.getMessage());
            } catch (BuildRouteException e) {
                System.out.println(e.getMessage());
                System.out.println("Program was returned to safe state");
            }
        } else throw new WrongArgumentException("KEY");
    }


    @Override
    public String getName() {
        return "insert null {element}";
    }

    @Override
    public String getDescription() {
        return "insert new element";
    }
}

