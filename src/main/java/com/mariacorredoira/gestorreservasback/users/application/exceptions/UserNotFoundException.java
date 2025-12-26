package com.mariacorredoira.gestorreservasback.users.application.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String param) {
        super("user not found: " + param);
    }

}
