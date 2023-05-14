package com.example.api.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long id, String nomeCliente, String celular) {

}
