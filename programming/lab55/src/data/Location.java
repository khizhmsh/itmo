package data;

public class Location {
    private Float x; //Поле не может быть null
    private Float y; //Поле не может быть null
    private int z;
    private String name; //Строка не может быть пустой, Поле может быть null

    public Location(Float x, Float y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public Location(Float x, Float y, String name) {
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public Float getX() {
        return x;
    }

    public void setX(Float x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
