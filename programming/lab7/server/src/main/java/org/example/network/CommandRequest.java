package org.example.network;

import org.example.managers.CommandManager;
import org.example.objects.Route;

import java.io.Serial;
import java.io.Serializable;

public class CommandRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String args;
    private String nameCommand = null;
    private Route route = null;

    public CommandRequest(String args, String nameCommand, Route route) {
        this.args = args;
        this.nameCommand = nameCommand;
        this.route = route;
    }

    public String getArgs() {
        return args;
    }

    public CommandRequest setArgs(String args) {
        this.args = args;
        return this;
    }

    public String getNameCommand() {
        return nameCommand;
    }

    public CommandRequest setNameCommand(String nameCommand) {
        this.nameCommand = nameCommand;
        return this;
    }

    public Route getRoute() {
        return route;
    }

    public CommandRequest setRoute(Route route) {
        this.route = route;
        return this;
    }
}
