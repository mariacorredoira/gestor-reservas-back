package com.mariacorredoira.gestorreservasback.activities.infrastructure.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@Data
public class ActivityRequest {
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "La fecha es obligatoria")
    private Date date;

    @NotNull(message = "La capacidad es obligatoria")
    private int capacity;

    private String image;

    private double price;
}
