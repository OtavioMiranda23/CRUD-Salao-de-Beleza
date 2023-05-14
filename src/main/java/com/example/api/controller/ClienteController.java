package com.example.api.controller;

import com.example.api.cliente.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository repository;
    @PostMapping
    public void cadastrarCliente(@RequestBody @Valid DadosCadastroCliente dados) {
        repository.save((new Cliente(dados)));
    }

    @GetMapping
    public Page<DadosListagemClientes> listarClientes(@PageableDefault(size = 10, sort = {"nomeCliente"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemClientes::new);
    }

    @PutMapping @Transactional
    public void atualizarClientes(@RequestBody @Valid DadosAtualizacaoCliente dados){
        Cliente cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        Cliente cliente = repository.getReferenceById(id);
        cliente.excluir();

    }

}
