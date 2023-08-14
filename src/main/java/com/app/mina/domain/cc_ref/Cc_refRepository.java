package com.app.mina.domain.cc_ref;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Cc_refRepository extends JpaRepository<Cc_ref, Long> {

    Cc_ref findByCodigo(String cc_ref);
}