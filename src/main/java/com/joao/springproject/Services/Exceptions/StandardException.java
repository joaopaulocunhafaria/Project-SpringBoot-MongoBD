package com.joao.springproject.Services.Exceptions;

import java.io.Serializable;

public class StandardException implements Serializable  {

    private final static Long serialVersionUID = 1L;

    private Long timestamp;
    private String message;
    private String path;
    private String error;
    private Integer status;

    public StandardException(Long timestamp, String message, String path, String error, Integer status) {
        this.timestamp = timestamp;
        this.message = message;
        this.path = path;
        this.error = error;
        this.status = status;
    }

    public StandardException() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
