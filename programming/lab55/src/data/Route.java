package data;

import generators.IdGenerator;
import managers.Validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Route implements Comparable<Route> {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Location from; //Поле может быть null
    private Location to; //Поле может быть null
    private int distance; //Значение поля должно быть больше 1

    public Route() {
        this.id = IdGenerator.generateId();
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = 0;


    }

    public Route(Long id) {
        this.id = id;
        this.name = null;
        this.coordinates = null;
        this.creationDate = LocalDateTime.now();
        this.from = null;
        this.to = null;
        this.distance = 0;
    }

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

    public String toXML() {
        return "id=\"" + id + "\"" +
                " name=\"" + name + "\"" +
                " coordinateX=\"" + coordinates.getX() + "\"" +
                " coordinateY=\"" + coordinates.getY() + "\"" +
                " creationDate=\"" + creationDate + "\"" +
                " fromX=\"" + from.getX() + "\"" +
                " fromY=\"" + from.getY() + "\"" +
                " fromZ=\"" + from.getZ() + "\"" +
                " fromName=\"" + from.getName() + "\"" +
                " toX=\"" + to.getX() + "\"" +
                " toY=\"" + to.getY() + "\"" +
                " toZ=\"" + to.getZ() + "\"" +
                " toName=\"" + to.getName() + "\"" +
                " distance=\"" + distance + "\"";
    }

    @Override
    public int compareTo(Route o) {
        return (int) (this.id - o.getId());
    }
}
