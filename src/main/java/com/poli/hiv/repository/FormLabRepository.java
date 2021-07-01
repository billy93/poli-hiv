package com.poli.hiv.repository;

import com.poli.hiv.model.FormLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormLabRepository extends JpaRepository<FormLab, Long> {
}
