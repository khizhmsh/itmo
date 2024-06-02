package org.example.objects;

import java.io.Serial;
import java.io.Serializable;

/**
 * Модель объекта "Локация"
 * Содержит геттеры/сеттеры каждого поля класса
 * Некоторые поля имеют ограничения. Он подписан под каждым методом поля
 *
 * @author khizhmsh
 * @since 1.0
 */

public class Location implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    /**
     * Локация по X
     * Поле не может быть null
     *
     * @since 1.0
     */
    private Float x;
    /**
     * Локация по Y
     * Поле не может быть null
     *
     * @since 1.0
     */
    private Float y;
    /**
     * Локация по Z
     * Поле не может быть null
     *
     * @since 1.0
     */
    private int z;
    /**
     * Имя локации
     * Строка не может быть пустой, Поле может быть null
     *
     * @since 1.0
     */
    private String name;
    /**
     * Базовый конструктор
     *
     * @since 1.0
     */

    public Location(Float x, Float y, int z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }
    /**
     * Конструктор без поля локации по Z
     *
     * @since 1.0
     */

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
