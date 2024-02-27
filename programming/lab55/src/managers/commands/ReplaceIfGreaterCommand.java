package managers.commands;

import data.Route;
import data.comparators.RouteDisComparator;
import generators.RouteGenerator;
import managers.CollectionManager;

import java.util.HashMap;

public class ReplaceIfGreaterCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        String key = args[1];
        HashMap<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        if (map.containsKey(key)) {
            Route route = RouteGenerator.createRoute(0L);
            if (c1.compare(route, map.get(key)) > 0) {
                CollectionManager.remove(key);
                CollectionManager.add(key, route);
            }
        }
    }

    @Override
    public String getName() {
        return "replace_if_greater";
    }

    @Override
    public String getDescription() {
        return "null {element} - update element by key if new bigger than element in collection with the same key";
    }

}
