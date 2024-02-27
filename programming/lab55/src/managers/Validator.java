package managers;

import exceptions.ReplayIdException;
import exceptions.WrongArgumentException;
import generators.IdGenerator;

public class Validator {
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

    public static void inputIsNotEmpty(String arg, String data) throws WrongArgumentException {
        if (arg.isEmpty() || arg.trim().isEmpty()) {
            throw new WrongArgumentException(data);
        }
    }

    public static void distanceIsOk(String arg) throws WrongArgumentException {
        if (Integer.parseInt(arg) < 1) {
            throw new WrongArgumentException("distance");

        }
    }

    public static void coordinatesXIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "X");
            Double.parseDouble(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Xc");
        }
    }

    public static void coordinatesYIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "Y");
            Long.parseLong(arg);
        } catch (Exception e) {
            throw new WrongArgumentException("Yc");
        }
    }

    public static void locationXIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "X");
            Float.parseFloat(arg);

        } catch (Exception e) {
            throw new WrongArgumentException("Xl");
        }
    }

    public static void locationYIsOk(String arg) throws WrongArgumentException {
        try {
            inputIsNotEmpty(arg, "Y");
            Float.parseFloat(arg);

        } catch (Exception e) {
            throw new WrongArgumentException("Yl");
        }
    }

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



