package com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {
    @NotNull(message = "El email es obligatorio")
    private String email;

    @NotNull(message = "La contraseña es obligatoria")
    private String password;
}
