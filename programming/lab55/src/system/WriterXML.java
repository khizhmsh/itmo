package system;

import data.Route;
import exceptions.ReplayIdException;
import exceptions.RootException;
import exceptions.WrongArgumentException;
import managers.CollectionManager;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;


public class WriterXML {

    public static void write(String path) throws IOException, RootException {
        File file = new File(path);
        if (!file.canRead()){
            throw new RootException("You do not have enough rights to write to the file");
        }
        StringBuilder xml = new StringBuilder("""
                <?xml version="1.0" encoding="UTF-8" ?>

                <collection>
                \t<routes>
                """);

        HashMap<String, Route> map = CollectionManager.getMap();
        for (String key : map.keySet()) {
            xml.append("\t\t<route ");
            xml.append("key=\"").append(key).append("\" ");
            Route route = map.get(key);
            xml.append(route.toXML()).append("/>\n");
        }

        xml.append("\t</routes>\n" + "</collection>");

        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
        bufferedOutputStream.write(xml.toString().getBytes());
        bufferedOutputStream.close();
    }
}
