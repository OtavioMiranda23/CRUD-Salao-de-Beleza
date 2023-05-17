package com.example.api.cliente;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;

    private String celular;


    private Boolean ativo;
    private String mensagem;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nomeCliente = dados.nomeCliente();
        this.celular = dados.celular();
        this.mensagem = dados.mensagem();
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if (dados.nomeCliente() != null){
        this.nomeCliente = dados.nomeCliente();
        }
        if (dados.celular() != null){
        this.celular = dados.celular();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
