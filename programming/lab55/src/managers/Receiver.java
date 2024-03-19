package managers;

import exceptions.BuildRouteException;
import exceptions.NoElementException;
import exceptions.WrongArgumentException;
import managers.commands.BaseCommand;
import resources.Coordinates;
import resources.Location;
import resources.Route;
import resources.comparators.RouteDisComparator;
import resources.comparators.RouteNameComparator;
import resources.generators.RouteGenerator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.*;

public class Receiver {
    private static Stack<File> st = new Stack<>(); // для избежания рекурсии

    public static void clear() {
        CollectionManager.getMap().clear();
        System.out.println("Map is clear");

    }

    public static void executeScript(String[] args, CollectionManager collectionManager) throws Exception {
        String line;
        File file;
        file = new File(args[1]);
        if (file.canRead()) {
            if (st.contains(file)){
                System.out.println("Recursion in script");
                return;
            }
            st.add(file);

            BufferedReader br = new BufferedReader(new FileReader(file));

            int countFields = 0;
            ArrayList<Class> sp = new ArrayList<>();
            Class<?> class1 = Route.class;
            Class<?> class2 = Location.class;
            Class<?> class3 = Coordinates.class;
            sp.add(class1);
            sp.add(class2);
            sp.add(class3);
            for (Class c : sp) {
                countFields += c.getDeclaredFields().length;
            }
            String[] org = new String[countFields];
            System.out.println(countFields);

            while ((line = br.readLine()) != null) {
                if (line.split(" ")[0].equals("insert")) {
                    String key = line.split(" ")[1];
                    for (int n = 0; n < countFields; n++) {
                        if ((line = br.readLine()) != null) {
                            org[n] = line;
                        }
                    }
                    Route route = new Route(org, true);
                    collectionManager.add(key, route);
                } else {
                    CommandManager commandManager = new CommandManager();
                    commandManager.startExecuting(line, collectionManager);
                }
            }
            st.pop();
        }
    }

    public static void exitCommand() {
        System.exit(1);
    }

    public static void filterContains(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (map.get(key).getName().contains(args[1])) {
                System.out.println(map.get(key));
            }
        }
    }

    public static void filterGreater(String[] args) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (Integer.parseInt(args[1]) < map.get(key).getDistance()) {
                System.out.println(map.get(key));
            }
        }
    }

    public static void help() throws Exception {
        CommandManager commandManager = new CommandManager();
        HashMap<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            System.out.println(command.getName() + " - " + command.getDescription());
        }
    }

    public static void info() throws Exception {
        System.out.println("Data type - " + CollectionManager.getMap().getClass().getName());
        System.out.println("Count of routes - " + CollectionManager.getMap().keySet().size());
        System.out.println("Init date - " + CollectionManager.getInitDate());
    }

    public static void insert(String[] args, CollectionManager collectionManager) throws WrongArgumentException {
        System.out.println("Start executing command...");
        if (args.length == 2 && !CollectionManager.getMap().containsKey(args[1])) {
            try {
                Route route = RouteGenerator.createRoute(0L);
                collectionManager.add(args[1], route);
                System.out.println("Element was added");
            } catch (WrongArgumentException e) {
                System.out.println(e.getMessage());
            } catch (BuildRouteException e) {
                System.out.println(e.getMessage());
                System.out.println("Program was returned to safe state");
            }
        } else throw new WrongArgumentException("KEY");


    }

    public static void printUnique() throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        Set<Integer> sp = new HashSet<>();
        for (String key : map.keySet()) {
            sp.add(map.get(key).getDistance());
        }
        for (Integer d : sp) {
            System.out.println(d);
        }
    }

    public static void removeCommand(String[] args, CollectionManager collectionManager) throws Exception {
        System.out.println("Start executing command...");
        try {
            collectionManager.remove(args[1]);
            System.out.println("Element was removed");
        } catch (NoElementException e) {
            System.err.println(e.getMessage());
            System.out.println("Program was returned to safe state");
        }
    }

    public static void removeGraterCommand(CollectionManager collectionManager) throws Exception {
        Route route = RouteGenerator.createRoute(0L);
        HashMap<String, Route> map = CollectionManager.getMap();

        RouteDisComparator c1 = new RouteDisComparator();
        RouteNameComparator c2 = new RouteNameComparator();
        ArrayList<String> keySet = new ArrayList<>();

        for (String key : map.keySet()) {
            if (c1.compare(route, map.get(key)) < 0) {
                keySet.add(key);
            } else if (c1.compare(route, map.get(key)) == 0) {
                if (c2.compare(route, map.get(key)) < 0) {
                    keySet.add(key);
                }
            }
        }
        int k = keySet.size();
        for (String key : keySet) {
            collectionManager.remove(key);
        }
        if (k == CollectionManager.getMap().size()) {
            System.out.println("Nothing was changed");
        }

    }

    public static void removeGraterKey(String[] args, CollectionManager collectionManager) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            if (key.compareTo(args[1]) > 0) {
                collectionManager.remove(key);
                System.out.println("Element with key " + key + " was deleted");
            }
        }
    }

    public static void replace(String[] args, CollectionManager collectionManager) throws Exception {
        String key = args[1];
        HashMap<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        if (map.containsKey(key)) {
            Route route = RouteGenerator.createRoute(0L);
            if (c1.compare(route, map.get(key)) > 0) {
                collectionManager.remove(key);
                collectionManager.add(key, route);
            }
        }
    }

    public static void saveFile() throws Exception {
        FileManager.write();
        System.out.println("Data was saved to:\n" + Console.data_path);
    }

    public static void show() throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        System.out.println(map.keySet());
        for (String x : map.keySet()) {
            System.out.println(map.get(x));
        }
        if (map.isEmpty()) {
            System.out.println(CollectionManager.getMap().getClass().getName() + " is empty");
        }
    }

    public static void update(String[] args, CollectionManager collectionManager) throws Exception {
        System.out.println("Start executing command...");

        boolean elementInCollection = false;
        Long id = Long.parseLong(args[1]);

        for (String key : CollectionManager.getMap().keySet()) {
            if (CollectionManager.getMap().get(key).getId().equals(id)) {
                System.out.println("Updating element with id " + args[1]);
                elementInCollection = true;

                Route route = RouteGenerator.createRoute(id);
                collectionManager.remove(key);
                collectionManager.add(key, route);

                System.out.println("Element was updated");
            }
        }
        if (!elementInCollection) {
            throw new NoElementException(id);
        }
    }

}
