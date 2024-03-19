package resources;

import resources.generators.IdGenerator;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
/**
 * Модель объекта "Дорога"
 * Содержит геттеры/сеттеры каждого поля класса
 * Некоторые поля имеют ограничения. Он подписан под каждым методом поля
 *
 * @author khizhmsh
 * @since 1.0
 */

public class Route implements Comparable<Route> {
    /**
     * Значение поля должно быть больше 0, Значение этого поля должно быть уникальным,
     * Значение этого поля должно генерироваться автоматически при помощи IdGenerator
     *
     * @see IdGenerator
     * @since 1.0
     */
    private long id;
    /**
     * Название дороги
     * Поле не может быть null, Строка не может быть пустой
     *
     * @since 1.0
     */
    private String name;
    /**
     * Координаты
     * Поле не может быть null
     *
     * @see Coordinates
     * @since 1.0
     */
    private Coordinates coordinates;
    /**
     * Дата создания организации
     * Поле не может быть null, Значение этого поля должно генерироваться автоматически
     *
     * @since 1.0
     */
    private java.time.LocalDateTime creationDate;
    /**
     * Локация c
     * Поле может быть null
     *
     * @since 1.0
     */
    private Location from;
    /**
     * Локация по
     * Поле может быть null
     *
     * @since 1.0
     */

    private Location to;
    /**
     * Дистанция
     * Значение поля должно быть больше 1
     *
     * @since 1.0
     */
    private int distance;
    /**
     * Базовый конструктор
     *
     * @author khizhmsh
     * @since 1.0
     */


    public Route() {
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = 0;


    }
    /**
     * Конструктор с заданным id
     *
     * @param id ID для дороги
     * @author khizhmsh
     * @since 1.0
     */

    public Route(Long id) {
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = 0;
    }
    /**
     * Конструктор с данными из списка
     * Метод проверяет корректность всех значений
     *
     * @param data параметры
     * @throws Exception исключение при некорректном значении или исключение при создании
     * @author khizhmsh
     * @since 1.0
     */


    public Route(String[] data) throws Exception {
        // Проверяем корректность всех значений
        Validator.idIsOk(data[1]);
        Validator.inputIsNotEmpty(data[2], "NAME");
        Validator.coordinatesXIsOk(data[3]);
        Validator.coordinatesYIsOk(data[4]);
        Validator.inputIsNotEmpty(data[5], "DATE");
        Validator.locationXIsOk(data[6]);
        Validator.locationYIsOk(data[7]);
        Validator.locationZIsOk(data[8]);
        Validator.locationNameIsOk(data[9]);
        Validator.locationXIsOk(data[10]);
        Validator.locationYIsOk(data[11]);
        Validator.locationZIsOk(data[12]);
        Validator.locationNameIsOk(data[13]);
        Validator.distanceIsOk(data[14]);

        this.id = Long.parseLong(data[1]);
        this.name = data[2];
        this.coordinates = new Coordinates(Double.parseDouble(data[3]), Long.parseLong(data[4]));
        this.creationDate =LocalDateTime.parse(data[5]);
        this.from = new Location(Float.parseFloat(data[6]), Float.parseFloat(data[7]), Integer.parseInt(data[8]), data[9]);
        this.to = new Location(Float.parseFloat(data[10]), Float.parseFloat(data[11]), Integer.parseInt(data[12]), data[13]);
        this.distance = Integer.parseInt(data[14]);
    }

    public Route(String[] data, boolean b) throws Exception {
        // Проверяем корректность всех значений
        Validator.idIsOk(data[0]);
        Validator.inputIsNotEmpty(data[1], "NAME");
        Validator.coordinatesXIsOk(data[2]);
        Validator.coordinatesYIsOk(data[3]);
        Validator.locationXIsOk(data[4]);
        Validator.locationYIsOk(data[5]);
        Validator.locationZIsOk(data[6]);
        Validator.locationNameIsOk(data[7]);
        Validator.locationXIsOk(data[8]);
        Validator.locationYIsOk(data[9]);
        Validator.locationZIsOk(data[10]);
        Validator.locationNameIsOk(data[11]);
        Validator.distanceIsOk(data[12]);

        this.id = Long.parseLong(data[0]);
        this.name = data[1];
        this.coordinates = new Coordinates(Double.parseDouble(data[2]), Long.parseLong(data[3]));
        this.creationDate =LocalDateTime.now();
        this.from = new Location(Float.parseFloat(data[4]), Float.parseFloat(data[5]), Integer.parseInt(data[6]), data[7]);
        this.to = new Location(Float.parseFloat(data[8]), Float.parseFloat(data[9]), Integer.parseInt(data[10]), data[11]);
        this.distance = Integer.parseInt(data[12]);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Location getFrom() {
        return from;
    }

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return to;
    }

    public void setTo(Location to) {
        this.to = to;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinateX=" + coordinates.getX() +
                ", coordinateY=" + coordinates.getY() +
                ", creationDate=" + creationDate +
                ", fromX=" + from.getX() +
                ", fromY=" + from.getY() +
                ", fromZ=" + from.getZ() +
                ", fromName=" + from.getName() +
                ", toX=" + to.getX() +
                ", toY=" + to.getY() +
                ", toZ=" + to.getZ() +
                ", toName=" + to.getName() +
                ", distance=" + distance +
                '}';
    }



    @Override
    public int compareTo(Route o) {
        return (int) (this.id - o.getId());
    }



}
