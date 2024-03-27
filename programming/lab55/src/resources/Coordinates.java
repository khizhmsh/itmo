package resources;
/**
 * Модель объекта "Координаты"
 * Содержит геттеры/сеттеры каждого поля класса
 * Некоторые поля имеют ограничения. Он подписан под каждым методом поля
 *
 * @author khizhmsh
 * @since 1.0
 */
public class Coordinates {
    /**
     * Координата по X
     * Поле не может быть null
     *
     * @since 1.0
     */
    private Double x;
    /**
     * Координата по Y
     * Поле не может быть null
     *
     * @since 1.0
     */
    private Long y;
    /**
     * Базовый конструктор
     *
     * @since 1.0
     */

    public Coordinates(Double x, Long y) {
        this.x = x;
        this.y = y;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }
}
