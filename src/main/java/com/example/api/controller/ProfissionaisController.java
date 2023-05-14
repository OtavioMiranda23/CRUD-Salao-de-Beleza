package com.example.api.controller;

import com.example.api.profissionais.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profissionais")
public class ProfissionaisController {
    @Autowired
    private ProfissionalRepository repository;
    @PostMapping
    public void cadastrarProfissional(@RequestBody @Valid DadosCadastroProfissinal dados) {
        repository.save(new Profissional(dados));
    }
    @GetMapping
    public Page<DadosListagemProfissional> listarProfissionais(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemProfissional::new);
    }
    @PutMapping @Transactional
    public void atualizarProfissional(@RequestBody @Valid DadosAtualizacaoProfissional dados) {
        Profissional profissional = repository.getReferenceById(dados.id());
        profissional.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id){
        Profissional profissional = repository.getReferenceById(id);
        profissional.excluir();


    }
}
