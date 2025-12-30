package com.mariacorredoira.gestorreservasback.users.application.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String param) {
        super("User not found: " + param);
    }

}
