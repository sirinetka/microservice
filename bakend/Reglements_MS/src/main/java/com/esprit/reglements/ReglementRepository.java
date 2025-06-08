package com.esprit.reglements;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReglementRepository extends JpaRepository<Reglement, Long> {
    List<Reglement> findByFactureId(Long factureId);
}
