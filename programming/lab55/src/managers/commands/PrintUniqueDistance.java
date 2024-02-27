package managers.commands;

import data.Route;
import managers.CollectionManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class PrintUniqueDistance implements BaseCommand {
    public void execute(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        Set<Integer> sp = new HashSet<>();
        for (String key : map.keySet()) {
            sp.add(map.get(key).getDistance());
        }
        for (Integer d : sp) {
            System.out.println(d);
        }
    }

    @Override
    public String getName() {
        return "print_unique_distance";
    }

    @Override
    public String getDescription() {
        return "display unique values of the distance field";
    }
}
