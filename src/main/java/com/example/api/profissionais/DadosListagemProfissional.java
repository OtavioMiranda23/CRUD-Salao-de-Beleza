package com.example.api.profissionais;



public record DadosListagemProfissional(Long id, String nomeProfissional, Especialidade especialidade, String email) {
    public DadosListagemProfissional(Profissional profissional) {
        this(profissional.getId(), profissional.getNomeProfissional(), profissional.getEspecialidade(), profissional.getCelular());
    }

}

