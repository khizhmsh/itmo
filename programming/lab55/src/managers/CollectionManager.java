package managers;

import data.Route;
import exceptions.NoElementException;
import generators.IdGenerator;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Hashtable;

public class CollectionManager {
    private static HashMap<String, Route> map = new HashMap<>();
    private static LocalDateTime date;

    public CollectionManager() {
        map = new HashMap<>();
        date = LocalDateTime.now();
        new IdGenerator();
    }

    public static void add(String key, Route route) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(key, route);
        IdGenerator.add(route.getId());
    }

    public static void remove(String key) throws NoElementException {
        if (map == null || !CollectionManager.map.containsKey(key)) {
            throw new NoElementException(key);
        } else {
            IdGenerator.remove(CollectionManager.map.get(key).getId());
            map.remove(key);
        }
    }

    public static HashMap<String, Route> getMap() {
        return map;
    }

    public static void setMap(HashMap<String, Route> map) {
        CollectionManager.map = map;
    }

    public static LocalDateTime getInitDate() {
        return date;
    }


}
