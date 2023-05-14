package com.example.api.profissionais;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroProfissinal(
        @NotBlank
        String nomeProfissional,
        @NotNull
        Especialidade especialidade,
        @NotBlank @Pattern(regexp = "\\d{9}")
        String celular,
        @NotBlank
        @Email
        String email) {
}
