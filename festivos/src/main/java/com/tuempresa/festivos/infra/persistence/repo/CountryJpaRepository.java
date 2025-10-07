package com.tuempresa.festivos.infra.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.CountryEntity;

public interface CountryJpaRepository extends JpaRepository<CountryEntity, Long> { }
