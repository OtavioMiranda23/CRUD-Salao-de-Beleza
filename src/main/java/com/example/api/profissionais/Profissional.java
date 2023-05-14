package com.example.api.profissionais;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
public class Profissional {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeProfissional;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private String celular;
    private String email;
    private Boolean ativo;

    public Profissional(DadosCadastroProfissinal dados) {
        this.ativo = true;
        this.nomeProfissional = dados.nomeProfissional();
        this.especialidade = dados.especialidade();
        this.celular = dados.celular();
        this.email = dados.email();

    }

    public void atualizarInformacoes(DadosAtualizacaoProfissional dados) {
        if (dados.nomeProfissional() != null){
        this.nomeProfissional = dados.nomeProfissional();
        }
        if (dados.especialidade() != null){
        this.especialidade = dados.especialidade();
        }
        if (dados.celular() != null){
        this.celular = dados.celular();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
