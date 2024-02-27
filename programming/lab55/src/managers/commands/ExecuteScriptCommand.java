package managers.commands;

import data.Route;
import managers.CollectionManager;
import managers.CommandManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ExecuteScriptCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        String line;
        File file;
        if (args.length == 3) {
            file = new File(args[1] + " " + args[2]);
        } else {
            file = new File(args[1]);
        }
        String[] org = new String[13];
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            if (line.split(" ")[0].equals("insert")) {
                String key = line.split(" ")[0];
                for (int n = 0; n < 13; n++) {
                    if ((line = br.readLine()) != null) {
                        org[n] = line;
                    }
                }
                CollectionManager.add(key, new Route(org));
            } else {
                CommandManager.startExecuting(line);
            }
        }
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "execute script from file";
    }
}
