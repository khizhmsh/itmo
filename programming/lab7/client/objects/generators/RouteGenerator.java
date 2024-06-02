package org.example.objects.generators;

import org.example.exceptions.BuildRouteException;
import org.example.exceptions.WrongArgumentException;
import org.example.objects.Coordinates;
import org.example.objects.Location;
import org.example.objects.Route;
import org.example.objects.Validator;

import java.util.Scanner;

import static org.example.objects.Validator.locationZIsOk;

/**
 * Класс генерирует объект Route, поэтапно запрашивая данные
 *
 * @author khizhmsh
 * @see Route
 * @since 1.0
 */
public class RouteGenerator {
    /**
     * Метод поэтапно запрашивает данные и проверяет их для создания объекта (Route)
     *
     * @author khizhmsh
     * @see Route
     * @since 1.0
     */
    public static Route createRoute(Long id) throws WrongArgumentException, BuildRouteException {
        System.out.println("Welcome to Route Builder.");

        String input, a, b, x, y, z = null, name = null;
        Coordinates coordinates;
        Location from;
        Location to;


        Scanner scanner = new Scanner(System.in);
        Route route;
        if (id == 0) {
            route = new Route();
        } else route = new Route(id);


        while (true) {
            try {
                System.out.print("Input name (String): ");
                input = scanner.nextLine();
                Validator.inputIsNotEmpty(input, "NAME");
                route.setName(input);
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Generate Coordinates");
        while (true) {
            try {
                System.out.print("Input x (Double): ");
                input = scanner.nextLine();
                Validator.coordinatesXIsOk(input);
                a = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input y (Long): ");
                input = scanner.nextLine();
                Validator.coordinatesYIsOk(input);
                b = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        coordinates = new Coordinates(Double.parseDouble(a), Long.parseLong(b));
        route.setCoordinates(coordinates);
        System.out.println("Generate Location From");

        while (true) {
            try {
                System.out.print("Input x (Float): ");
                input = scanner.nextLine();
                Validator.locationXIsOk(input);
                x = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input y (Float): ");
                input = scanner.nextLine();
                Validator.locationYIsOk(input);
                y = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input z (Integer): ");
                input = scanner.nextLine().trim();
                locationZIsOk(input);
                if (input.isEmpty()) {
                    break;
                } else {
                    z = input;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input name (String): ");
                input = scanner.nextLine().trim();
                Validator.locationNameIsOk(input);
                if (input.isEmpty()) {
                    name = null;
                } else{
                    name = input;
                }
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        if (z == null) {
            from = new Location(Float.parseFloat(x), Float.parseFloat(y), name);
        } else {
            from = new Location(Float.parseFloat(x), Float.parseFloat(y), Integer.parseInt(z), name);
        }
        route.setFrom(from);

        System.out.println("Generate Location To");
        while (true) {
            try {
                System.out.print("Input x (Float): ");
                input = scanner.nextLine();
                Validator.locationXIsOk(input);
                x = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input y (Float): ");
                input = scanner.nextLine();
                Validator.locationYIsOk(input);
                y = input;
                break;

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input z (Integer): ");
                input = scanner.nextLine().trim();
                locationZIsOk(input);
                if (input.isEmpty()) {
                    break;
                } else {
                    z = input;
                }
                break;

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        while (true) {
            try {
                System.out.print("Input name (String): ");
                input = scanner.nextLine().trim();
                Validator.locationNameIsOk(input);
                if (input.isEmpty()) {
                    name = null;
                } else{
                    name = input;
                }
                break;


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

        if (z == null) {
            to = new Location(Float.parseFloat(x), Float.parseFloat(y), name);
        } else {
            to = new Location(Float.parseFloat(x), Float.parseFloat(y), Integer.parseInt(z), name);
        }
        route.setTo(to);

        System.out.println("Generate Distance");
        while (true) {
            try {
                System.out.print("Input distance (Int): ");
                input = scanner.nextLine();
                Validator.distanceIsOk(input);
                route.setDistance(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        return route;
    }
}
