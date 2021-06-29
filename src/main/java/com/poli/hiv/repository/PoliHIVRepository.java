package com.poli.hiv.repository;

import com.poli.hiv.model.PoliHIV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoliHIVRepository extends JpaRepository<PoliHIV, Long> {
}
