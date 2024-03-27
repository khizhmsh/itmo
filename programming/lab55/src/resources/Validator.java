package resources;

import exceptions.ReplayIdException;
import exceptions.WrongArgumentException;
import resources.generators.IdGenerator;
/**
 * Данный класс проверяет корректность каждого параметра Route
 *
 * @author khizhmsh
 * @see Route
 * @since 1.0
 */
public class Validator {
    /**
     * Проверяет корректность ID
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если возникла проблема
     * @throws ReplayIdException      если такой ID уже зарезервирован
     */
    public static void idIsOk(String arg) throws WrongArgumentException, ReplayIdException {
        long id;
        try {
            id = Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("ID");
        }

        if (!IdGenerator.idIsUnique(id)) {
            throw new ReplayIdException(id);
        }
    }
    /**
     * Проверяет, что значение строки не null
     *
     * @param arg  аргумент строки
     * @param data какой тип данных из Organization мы проверяем
     * @throws WrongArgumentException если значение arg null
     */

    public static void inputIsNotEmpty(String arg, String data) throws WrongArgumentException {
        if (arg.isEmpty() || arg.trim().isEmpty()) {
            throw new WrongArgumentException(data);
        }
    }
    /**
     * Проверяет корректность дистанции
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     */

    public static void distanceIsOk(String arg) throws WrongArgumentException {
        if (Integer.parseInt(arg) < 1) {
            throw new WrongArgumentException("distance");

        }
    }
    /**
     * Проверяет корректность координат по X
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Coordinates
     */

    public static void coordinatesXIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "X");
            Double.parseDouble(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Xc");
        }
    }
    /**
     * Проверяет корректность координат по Y
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Coordinates
     */

    public static void coordinatesYIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "Y");
            Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Yc");
        }
    }
    /**
     * Проверяет корректность локации по X
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Location
     */

    public static void locationXIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "X");
            Float.parseFloat(arg);

        } catch (Exception e) {
            throw new WrongArgumentException("Xl");
        }
    }
    /**
     * Проверяет корректность локации по Y
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Location
     */

    public static void locationYIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "Y");
            Float.parseFloat(arg);

        } catch (Exception e) {
            throw new WrongArgumentException("Yl");
        }
    }
    /**
     * Проверяет корректность локации по Z
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Location
     */

    public static void locationZIsOk(String arg) throws WrongArgumentException {
        try {
            String n = arg.trim();
            if (n.isEmpty()) {
                return;
            } else {
                Integer.parseInt(arg);
            }
        } catch (Exception e) {
            throw new WrongArgumentException("Zl");
        }
    }
    /**
     * Проверяет корректность имени локации
     *
     * @param arg аргумент строки
     * @throws WrongArgumentException если координата некорректна
     * @see Location
     */

    public static void locationNameIsOk(String arg) throws WrongArgumentException {
        try {
            String n = arg.trim();
            if (n.isEmpty()) {
                return;

            } else {
                inputIsNotEmpty(arg, "name");
            }
        } catch (Exception e) {
            throw new WrongArgumentException("nameL");
        }
    }


}



