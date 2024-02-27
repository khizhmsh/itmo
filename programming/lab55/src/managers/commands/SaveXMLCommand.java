package managers.commands;

import managers.Console;
import system.WriterXML;


public class SaveXMLCommand implements BaseCommand {
    @Override
    public void execute(String[] args) throws Exception {
        WriterXML.write(Console.data_path);
        System.out.println("Data was saved to:\n" + Console.data_path);
    }


    @Override
    public String getName() {
        return "save";
    }

    @Override
    public String getDescription() {
        return "save data to XML file (path)";
    }
}

