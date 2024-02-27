package system;

import data.Route;
import exceptions.RootException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;


public class ReaderXML {
    public static void read(String path, boolean firstStart) throws ParserConfigurationException, IOException, SAXException, RootException, WrongArgumentException {
        File file = new File(path);
        if (!file.canRead()) {
            throw new RootException("You do not have enough rights to read the file");
        }
        // Чтение из файла
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        InputSource in = new InputSource(new StringReader(text.toString()));

        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Запарсили XML, создав структуру Document. Теперь у нас есть доступ ко всем элементам, каким нам нужно.
        Document document = builder.parse(in);

        NodeList routeElements = document.getDocumentElement().getElementsByTagName("route");


        // Перебор всех элементов employee
        for (int i = 0; i < routeElements.getLength(); i++) {

            Node route = routeElements.item(i);

            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = route.getAttributes();
            String[] data = {attributes.getNamedItem("key").getNodeValue(), attributes.getNamedItem("id").getNodeValue(),
                    attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("coordinateX").getNodeValue(),
                    attributes.getNamedItem("coordinateY").getNodeValue(), attributes.getNamedItem("creationDate").getNodeValue(),
                    attributes.getNamedItem("fromX").getNodeValue(), attributes.getNamedItem("fromY").getNodeValue(),
                    attributes.getNamedItem("fromZ").getNodeValue(), attributes.getNamedItem("fromName").getNodeValue(),
                    attributes.getNamedItem("toX").getNodeValue(), attributes.getNamedItem("toY").getNodeValue(),
                    attributes.getNamedItem("toZ").getNodeValue(), attributes.getNamedItem("toName").getNodeValue(),
                    attributes.getNamedItem("distance").getNodeValue()};

            String key = data[0];
            try {
                Route route1 = new Route(data);
                CollectionManager.add(key, route1);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

