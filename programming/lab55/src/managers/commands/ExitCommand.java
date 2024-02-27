package managers.commands;

public class ExitCommand implements BaseCommand {
    @Override
    public void execute(String[] args) {
        System.exit(1);
    }

    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public String getDescription() {
        return "close command without save";
    }
}

