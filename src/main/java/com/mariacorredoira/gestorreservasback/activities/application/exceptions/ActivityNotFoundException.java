package com.mariacorredoira.gestorreservasback.activities.application.exceptions;

public class ActivityNotFoundException extends RuntimeException {

    public ActivityNotFoundException(Long param) {
        super("Activity not found: " + param);
    }

}
