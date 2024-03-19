package system;

import resources.Route;
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

/**
 * Данный класс выполняет чтение данных, которые хранятся в формате XML
 *
 * @author khizhmsh
 * @see java.util.HashMap
 * @since 1.0
 */

public class ReaderXML {
    /**
     * Читает данные из файла в коллекцию
     *
     * @throws Exception если возникла проблема
     * @see CollectionManager
     */
    public static void read(String text, CollectionManager collectionManager) throws ParserConfigurationException, IOException, SAXException, RootException, WrongArgumentException {
        InputSource in = new InputSource(new StringReader(text.toString()));
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);
            NodeList routeElements = document.getDocumentElement().getElementsByTagName("route");

            if (routeElements.getLength() == 0) {
                System.out.println("File is empty");
            } else {
                for (int i = 0; i < routeElements.getLength(); i++) {
                    Node routeNode = routeElements.item(i);
                    NamedNodeMap attributes = routeNode.getAttributes();
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
                        collectionManager.add(key, new Route(data));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        } catch (Exception e){
            System.out.println("File is empty or damage");
        }
    }
}

