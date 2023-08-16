package com.app.mina.domain.categoria_ref;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Categoria_refRepository extends JpaRepository<Categoria_ref, Long> {
    Categoria_ref findByNome(String categoria_ref);
}
