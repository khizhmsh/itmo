package org.example.network;

import org.example.objects.Route;

import java.io.Serial;
import java.io.Serializable;

public class Request implements Serializable {

    @Serial
    private static final long serialVersionUID = 5760575944040770153L;
    private CommandRequest commandRequest = null;
    private String login = null;
    private String password = null;

    public Request() {

    }

    public CommandRequest getCommandRequest() {
        return commandRequest;
    }

    public Request setCommandRequest(CommandRequest commandRequest) {
        this.commandRequest = commandRequest;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public Request setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Request setPassword(String password) {
        this.password = password;
        return this;
    }
}
