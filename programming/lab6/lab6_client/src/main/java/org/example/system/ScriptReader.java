package org.example.system;

import org.example.network.Request;
import org.example.network.RequestHandler;
import org.example.network.Response;
import org.example.objects.Coordinates;
import org.example.objects.Location;
import org.example.objects.Route;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class ScriptReader {
    private static Stack<File> st = new Stack<>(); // для избежания рекурсии
    public static void read(String script, Server server) throws Exception {
        String line;
        File file;
        file = new File(script);
        if (file.canRead()) {
            System.out.println(1);
            if (st.contains(file)) {
                System.out.println("Recursion in script");
                return ;
            }
            st.add(file);

            BufferedReader br = new BufferedReader(new FileReader(file));

            int countFields = 0;
            ArrayList<Class> sp = new ArrayList<>();
            Class<?> class1 = Route.class;
            Class<?> class2 = Location.class;
            Class<?> class3 = Coordinates.class;
            sp.add(class1);
            sp.add(class2);
            sp.add(class3);
            for (Class c : sp) {
                countFields += c.getDeclaredFields().length;
            }
            String[] org = new String[countFields];

            while ((line = br.readLine()) != null) {
                String key = null;
                Route route = null;
                Request request = null;
                String command = line.split(" ")[0];
                if (command.equals("insert") || command.contains("replace") || command.contains("update") || (command.contains("remove_greater") && !command.contains("remove_greater_key"))) {
                    key = line.split(" ")[1];
                    for (int n = 0; n < countFields; n++) {
                        if ((line = br.readLine()) != null) {
                            org[n] = line;
                        }
                    }
                    request = RequestHandler.formRequest(command + " " + key, org);
                } else request = RequestHandler.formRequest(command + " " + key, null);
                server.send(request);
                Response response = server.getResponse();
                System.out.println(response.getMessage());
            }
            st.pop();
        }
    }
}
