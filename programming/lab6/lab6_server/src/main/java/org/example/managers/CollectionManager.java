package org.example.managers;

import org.example.exceptions.NoElementException;
import org.example.objects.Route;
import org.example.objects.generators.IdGenerator;

import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * Данный класс отвечает за взаимодействие с коллекцией
 * Содержит коллекцию команд
 *
 * @author khizhmsh
 * @see org.example.managers.commands.BaseCommand
 * @see Route
 * @since 1.0
 */
public class CollectionManager {
    private static HashMap<String, Route> map = new HashMap<>();
    private static LocalDateTime date;

    /**
     * Базовый конструктор
     */

    public CollectionManager() {
        map = new HashMap<>();
        date = LocalDateTime.now();
        new IdGenerator();
    }

    /**
     * Добавить новую организацию по ключу
     *
     * @param key   ключ
     * @param route дорога
     */

    public void add(String key, Route route) {
        if (map == null) {
            map = new HashMap<>();
        }
        // route.setId(IdGenerator.generateId());
        map.put(key, route);
    }

    /**
     * Удалить новую дорогу по ключу
     *
     * @param key ключ
     */

    public void remove(String key) throws NoElementException {
        if (map == null || !CollectionManager.map.containsKey(key)) {
            throw new NoElementException(key);
        } else {
            IdGenerator.remove(CollectionManager.map.get(key).getId());
            map.remove(key);
        }
    }

    /**
     * Получить коллекцию
     *
     * @return коллекция
     */

    public static HashMap<String, Route> getMap() {
        return map;
    }

    public static void setMap(HashMap<String, Route> map) {
        CollectionManager.map = map;
    }

    /**
     * Получить дату инициализации коллекции
     *
     * @return дата инициализации
     */
    public static LocalDateTime getInitDate() {
        return date;
    }

    public void remove1(String key) {
        map.remove(key);
    }

    public static void removeGreaterKey(String key){
        map.entrySet().stream()
                .filter(entry -> entry.getKey().compareTo(key) > 0)
                .forEach(entry -> {map.remove(entry.getKey());
                });
    }


}
