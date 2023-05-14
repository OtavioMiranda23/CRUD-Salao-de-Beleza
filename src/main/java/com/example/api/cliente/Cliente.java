package com.example.api.cliente;

import com.example.api.endereco.DadosEndereco;
import com.example.api.endereco.Endereco;
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
    @Embedded
    private Endereco endereco;
    private String celular;
    private String email;
    private String nascimento;
    private Boolean ativo;

    public Cliente(DadosCadastroCliente dados) {
        this.ativo = true;
        this.nomeCliente = dados.nomeCliente();
        this.endereco = new Endereco(dados.endereco());
        this.celular = dados.celular();
        this.email = dados.email();
        this.nascimento = dados.nascimento();
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if (dados.nomeCliente() != null){
        this.nomeCliente = dados.nomeCliente();
        }
        if (dados.celular() != null){
        this.celular = dados.celular();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
