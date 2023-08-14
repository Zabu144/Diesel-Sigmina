package com.app.mina.domain.ccRef;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CcRefRepository extends JpaRepository<CcRef, Long> {

    CcRef findByCodigo(String ccRef);
}