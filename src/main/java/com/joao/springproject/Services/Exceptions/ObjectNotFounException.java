
package com.joao.springproject.Services.Exceptions;

public class ObjectNotFounException extends RuntimeException {

    public ObjectNotFounException(String message) {
        super(message);
    }
}