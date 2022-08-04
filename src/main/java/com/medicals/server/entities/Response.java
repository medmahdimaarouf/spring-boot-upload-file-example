package com.medicals.server.core.entities;

import com.fasterxml.jackson.annotation.JsonInclude;


import java.io.Serializable;

public class Response implements Serializable {
    protected boolean success;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    protected String message = null;

    public Response() {
    }

    public Response(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
/*

 */
}