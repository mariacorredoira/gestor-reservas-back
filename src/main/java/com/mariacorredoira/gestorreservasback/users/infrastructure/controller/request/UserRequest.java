package com.mariacorredoira.gestorreservasback.users.infrastructure.controller.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserRequest {
    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "El primer apellido es obligatorio")
    private String firstSurname;

    private String secondSurname;

    @NotNull(message = "El email es obligatorio")
    @Email(message = "El email no es válido")
    private String email;

    @Size(min = 8, message = "El tamaño mínimo de contraseña es de 8 caracteres")
    @NotNull(message = "La contraseña es obligatoria")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).+$",
            message = "La contraseña debe contener al menos una mayúscula y un símbolo"
    )
    private String password;
}
