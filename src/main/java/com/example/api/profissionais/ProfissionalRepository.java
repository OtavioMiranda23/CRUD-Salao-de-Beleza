package com.example.api.profissionais;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfissionalRepository extends JpaRepository<Profissional, Long> {
    Page<Profissional> findAllByAtivoTrue(Pageable paginacao);
}
