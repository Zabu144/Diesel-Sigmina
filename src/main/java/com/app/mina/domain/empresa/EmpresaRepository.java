package com.app.mina.domain.empresa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findByNome(String empresa);
}
