package org.example.network;

import org.example.objects.Route;

import java.io.Serial;
import java.io.Serializable;

public class CommandRequest implements Serializable {
    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private String args;
    private String nameCommand = null;
    private Route route = null;

    public CommandRequest(String nameCommand, String args, Route route) {
        this.nameCommand = nameCommand;
        this.args = args;
        this.route = route;
    }

    public CommandRequest() {
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
