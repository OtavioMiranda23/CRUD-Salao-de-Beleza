package com.example.api.cliente;


import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.Pattern;

public record DadosCadastroCliente(
        @NotBlank
        String nomeCliente,
        @NotBlank //@Pattern(regexp = "\\d{8}")
        String celular,
        @NotBlank
        String mensagem)
 {

}