package com.mybank.msclientepersona.domain.exception;

import com.mybank.msclientepersona.domain.model.Client;

public class ClientException  extends RuntimeException{
    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
