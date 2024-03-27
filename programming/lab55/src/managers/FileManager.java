package managers;

import exceptions.RootException;
import exceptions.WrongArgumentException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import system.ReaderXML;
import system.WriterXML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileManager {
    /**
     * Читает данные из файла в коллекцию
     *
     * @throws Exception если возникла проблема
     * @see CollectionManager
     */
    public static void read(CollectionManager collectionManager) throws RootException, IOException, WrongArgumentException, ParserConfigurationException, SAXException {
        File file = new File(Console.data_path);
        if (!file.canRead()) {
            throw new RootException("You do not have enough rights to read the file");
        }
        var br = new BufferedReader(new InputStreamReader(new FileInputStream(Console.data_path), StandardCharsets.UTF_8));
        String line;
        StringBuilder text = new StringBuilder();
        while ((line = br.readLine()) != null) {
            text.append(line);
        }
        ReaderXML.read(String.valueOf(text), collectionManager);
    };
    /**
     * Записывает данные коллекции в файл
     *
     * @see CollectionManager
     * @throws Exception если возникла проблема
     */
    public static void write() throws TransformerException, IOException, ParserConfigurationException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.newDocument();

        WriterXML.write(document);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new FileWriter(Console.data_path));
        transformer.transform(domSource, streamResult);
    }
}
