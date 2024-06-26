package org.example.system;

import org.example.network.CommandRequest;
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
                if (command.contains("execute_script")){
                    System.out.println(line);
                    file = new File(line.split(" ")[1]);
                    if (file.canRead()) {
                        if (st.contains(file)) {
                            System.out.println("Recursion in script");
                        }else ScriptReader.read(command.split(" ")[1], server);}
                }
                if (command.equals("insert") || command.contains("replace") || command.contains("update") || (command.contains("remove_greater") && !command.contains("remove_greater_key"))) {
                    key = line.split(" ")[1];
                    for (int n = 0; n < countFields - 3; n++) {
                        if ((line = br.readLine()) != null) {
                            org[n] = line;
                        }
                    }
                    CommandRequest commandRequest =new CommandRequest(command, key, new Route(org));
                    request = new Request();
                    request.setCommandRequest(commandRequest);
                    request.setLogin(RequestHandler.getLogin());
                    request.setPassword(RequestHandler.getPassword());
                    System.out.println(commandRequest.getRoute());
                } else {
                    CommandRequest commandRequest =new CommandRequest(command, key, null);
                    request = new Request();
                    request.setCommandRequest(commandRequest);
                    request.setLogin(RequestHandler.getLogin());
                    request.setPassword(RequestHandler.getPassword());
                }
                server.send(request);
                Response response = server.getResponse();
                System.out.println(response.getMessage());
            }
            st.pop();
        }
    }
}
