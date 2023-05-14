package com.example.api.cliente;

import lombok.AllArgsConstructor;


public record DadosListagemClientes(Long id, String nomeCliente, String celular, String email) {
    public DadosListagemClientes(Cliente cliente) {
        this(cliente.getId(), cliente.getNomeCliente(), cliente.getCelular(), cliente.getEmail());

    }
}
