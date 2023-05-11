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
    @Enumerated
    private Especialidade especialidade;
    private String celular;
    private String email;

    public Profissional(DadosCadastroProfissinal dados) {
        this.nomeProfissional = dados.nomeProfissional();
        this.especialidade = dados.especialidade();
        this.celular = dados.celular();
        this.email = dados.email();

    }
}
