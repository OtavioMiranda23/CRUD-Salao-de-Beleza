package com.example.api.profissionais;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfissional(@NotNull Long id, String nomeProfissional, Especialidade especialidade, String celular) {
}
