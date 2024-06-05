package org.example.managers;

import org.example.db.DataBaseManager;
import org.example.exceptions.*;
import org.example.managers.commands.BaseCommand;
import org.example.objects.Route;
import org.example.objects.comparators.RouteDisComparator;
import org.example.objects.comparators.RouteNameComparator;
import org.example.network.Request;
import org.example.system.Server;

import java.util.*;
import java.util.stream.Collectors;

public class Receiver {

    public static void clear() {
        System.out.println("Map is clear");
        CollectionManager.getMap().clear();

    }

    public static String filterContains(String nameSubstring) {
        HashMap<String, Route> map = CollectionManager.getMap();
        return map.values().stream()
                .filter(route -> route.getName().contains(nameSubstring))
                .map(Route::toString)
                .collect(Collectors.joining("\n"));
    }

    public static String filterGreater(String distanceStr) {
        HashMap<String, Route> map = CollectionManager.getMap();
        int distance = Integer.parseInt(distanceStr);

        return map.values().stream()
                .filter(route -> route.getDistance() > distance)
                .map(Route::toString)
                .collect(Collectors.joining("\n"));
    }

    public static String help() throws Exception {
        StringBuilder st = new StringBuilder();
        CommandManager commandManager = new CommandManager();
        HashMap<String, BaseCommand> commandList = commandManager.getCommandList();
        for (String name : commandList.keySet()) {
            BaseCommand command = commandList.get(name);
            st.append(command.getName() + " - " + command.getDescription()).append("\n");
        }
        return st.toString();
    }

    public static String info() throws Exception {
        StringBuilder st = new StringBuilder();
        st.append("Data type - " + CollectionManager.getMap().getClass().getName()).append("\n");
        st.append("Count of routes - " + CollectionManager.getMap().keySet().size()).append("\n");
        st.append("Init date - " + CollectionManager.getInitDate()).append("\n");
        return st.toString();
    }

    public static String insert(String login, String arg, Route route, CollectionManager collectionManager) throws WrongArgumentException {
        if (CollectionManager.getDataBaseManager().addRoute(login, arg, route)){
            route.setId(CollectionManager.getDataBaseManager().getRouteId(arg));
            collectionManager.add(arg, route);
            return "Element was added";
        } else return "Something goes wrong " + CollectionManager.getDataBaseManager().addRoute(login, arg, route);
    }

    public static String printUnique() {
        HashMap<String, Route> map = CollectionManager.getMap();
        return map.values().stream()
                .map(Route::getDistance)
                .distinct()
                .map(String::valueOf) // Преобразуем числа в строки
                .collect(Collectors.joining("\n"));
    }

    public static String removeCommand(String login, String arg, CollectionManager collectionManager) {
         try {
            if (CollectionManager.getDataBaseManager().deleteRoute(login, arg)){
                collectionManager.remove(arg);
                return "Element was deleted";
            } else return "Something goes wrong";
        } catch (NoElementException e) {
            return e.getMessage();
        }

    }

    public static String removeGraterCommand(String login, Route route, CollectionManager collectionManager) {
        Map<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        RouteNameComparator c2 = new RouteNameComparator();
        int k = CollectionManager.getMap().size();
        try {
            long countRemoved = map.entrySet().stream()
                    .filter(entry -> c1.compare(route, entry.getValue()) < 0
                            || (c1.compare(route, entry.getValue()) == 0 && c2.compare(route, entry.getValue()) < 0))
                    .peek(entry -> {
                        try {
                            if (CollectionManager.getDataBaseManager().deleteRoute(login, entry.getKey())){
                                collectionManager.remove(entry.getKey());
                            }
                        } catch (NoElementException e) {
                            throw new RuntimeException(e);
                        }
                    }) // Удаляем элемент внутри stream
                    .count();
            return countRemoved + " elements were deleted";
        } catch (ConcurrentModificationException e){
                return k - CollectionManager.getMap().size() + " elements were deleted";
            }
    }


    public static String removeGraterKey(String login, String key, CollectionManager collectionManager) {
        int k = CollectionManager.getMap().size();
        try {
            CollectionManager.getMap().entrySet().stream()
                    .filter(entry -> entry.getKey().compareTo(key) > 0)
                    .forEach(entry -> {
                        try {
                            if (CollectionManager.getDataBaseManager().deleteRoute(login, entry.getKey())){
                                collectionManager.remove(entry.getKey());
                            }
                        } catch (NoElementException e) {
                            throw new RuntimeException(e);
                        }
                    });
            return k - CollectionManager.getMap().size() + " elements were deleted";
        } catch (ConcurrentModificationException e){
            return k - CollectionManager.getMap().size() + " elements were deleted";
        }
    }

    public static String replace(String login, String key, Request request, CollectionManager collectionManager) throws Exception {
        HashMap<String, Route> map = CollectionManager.getMap();
        RouteDisComparator c1 = new RouteDisComparator();
        if (CollectionManager.getMap().containsKey(key)) {
            Route route = request.getCommandRequest().getRoute();
            if (c1.compare(route, map.get(key)) > 0) {
                if (CollectionManager.getDataBaseManager().updateByKeyRoute(login, key, route)){
                    collectionManager.remove(key);
                    collectionManager.add(key, route);
                    return "Element was changed";
                }
            }
            return "Element new less than old";
        }
        return "No element with key";
    }



    public static String show(){
        StringBuilder st = new StringBuilder();

        HashMap<String, Route> map = CollectionManager.getMap();
        Map<String, Route> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((route1, route2) -> Double.compare(route1.getDistance(), route2.getDistance())))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        for (String x : sortedMap.keySet()) {
            st.append("key = " + x + " " + map.get(x)).append("\n");
        }
        if (map.isEmpty()) {
            return CollectionManager.getMap().getClass().getName() + " is empty";
        }
        return st.toString();
    }

    public static String update(String login, String arg, Route route, CollectionManager collectionManager) throws NoElementException {
        Long id = Long.parseLong(arg);
        for (String key : CollectionManager.getMap().keySet()) {
            if (CollectionManager.getMap().get(key).getId().equals(id)) {
                if (CollectionManager.getDataBaseManager().updateByIdRoute(login, Math.toIntExact(id), route)){
                    route.setId(CollectionManager.getMap().get(key).getId());
                    collectionManager.remove(key);
                    collectionManager.add(key, route);
                    return "Element was updated";
                }
                return "This is not your element";
            }
        }
        throw new NoElementException(id);
    }

}
