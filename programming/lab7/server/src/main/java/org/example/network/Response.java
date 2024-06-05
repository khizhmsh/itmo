package org.example.network;

import java.io.Serializable;

public class Response implements Serializable {
    private String message;

    public Response() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
