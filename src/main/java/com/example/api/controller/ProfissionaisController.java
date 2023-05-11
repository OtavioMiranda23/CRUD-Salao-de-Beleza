package com.example.api.controller;

import com.example.api.profissionais.DadosCadastroProfissinal;
import com.example.api.profissionais.Profissional;
import com.example.api.profissionais.ProfissionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("profissionais")
public class ProfissionaisController {
    @Autowired
    private ProfissionalRepository repository;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroProfissinal dados) {
        repository.save(new Profissional(dados));
    }
}
