package com.medicals.server.core.entities;

import java.io.Serializable;

public class ErrorResponse extends Response implements Serializable {
    private String error;

    public ErrorResponse(String error) {
        super();
        this.success = false;
        this.error = error;
    }

    public ErrorResponse(String error, String message) {
        super(message);
        this.success = false;
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}