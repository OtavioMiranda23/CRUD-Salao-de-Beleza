package com.example.api.cliente;

import com.example.api.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        String nomeCliente,
        @NotNull @Valid
        DadosEndereco endereco,
        @NotBlank @Pattern(regexp = "\\d{9}")
        String celular,
        @NotBlank @Email
        String email,
        @NotBlank
        String nascimento) {

}