package org.example.system;

import org.example.db.DataBaseManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class Configurator {
    private String user;
    private String password;
    private String link;
    private int port;

    public Configurator(String filePath) throws IOException {
        Properties info = new Properties();
        info.load(new FileInputStream(filePath));

        this.user = info.getProperty("user");
        this.password = info.getProperty("password");
        this.link = info.getProperty("jdbcUrl_local");
        this.port = Integer.parseInt(info.getProperty("port"));
    }

    public String getUser() {
        return user;
    }

    public void setUser(String name) {
        this.user = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
