package system;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import resources.Route;
import managers.CollectionManager;



/**
 * Данный класс выполняет запись данных в формате XML
 *
 * @author khizhmsh
 * @see java.util.HashMap
 * @since 1.0
 */


public class WriterXML {
    /**
     * Записывает данные коллекции в файл
     *
     * @see CollectionManager
     * @throws Exception если возникла проблема
     */
    public static void write(Document document) {
        try {
            Element rootElement = document.createElement("collection");
            document.appendChild(rootElement);
            Route route;
            for (String key : CollectionManager.getMap().keySet()) {
                route = CollectionManager.getMap().get(key);
                Element element = document.createElement("route");
                element.setAttribute("key", key);
                element.setAttribute("id", String.valueOf(route.getId()));
                element.setAttribute("name", route.getName());
                element.setAttribute("coordinateX", String.valueOf(route.getCoordinates().getX()));
                element.setAttribute("coordinateY", String.valueOf(route.getCoordinates().getY()));
                element.setAttribute("creationDate", String.valueOf(route.getCreationDate()));

                element.setAttribute("fromX", String.valueOf(route.getFrom().getX()));
                element.setAttribute("fromY", String.valueOf(route.getFrom().getY()));
                element.setAttribute("fromZ", String.valueOf(route.getFrom().getZ()));
                element.setAttribute("fromName", route.getFrom().getName());

                element.setAttribute("toX", String.valueOf(route.getTo().getX()));
                element.setAttribute("toY", String.valueOf(route.getTo().getY()));
                element.setAttribute("toZ", String.valueOf(route.getTo().getZ()));
                element.setAttribute("toName", route.getTo().getName());

                element.setAttribute("distance", String.valueOf(route.getDistance()));

                rootElement.appendChild(element);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
