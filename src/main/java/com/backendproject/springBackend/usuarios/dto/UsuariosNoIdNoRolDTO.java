package com.backendproject.springBackend.usuarios.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UsuariosNoIdNoRolDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String nombre;

    @NotBlank(message = "El apellido no puede estar vacío.")
    private String apellido;
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com$", message = "El correo electrónico debe tener el formato correcto (ejemplo: correo@dominio.com)")
    @NotBlank(message = "El email no puede estar vacío.")
    @Schema(example = "correo@dominio.com")
    private String email;
    @NotBlank(message = "La contraseña no puede estar vacía.")
    private String password;
    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    private LocalDate birthday;
}