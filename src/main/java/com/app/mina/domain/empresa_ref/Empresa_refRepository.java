package com.app.mina.domain.empresa_ref;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Empresa_refRepository extends JpaRepository<Empresa_ref, Long> {
    Empresa_ref findByNome(String empresa_ref);
}
