package com.tuempresa.festivos.infra.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.HolidayTypeEntity;

public interface HolidayTypeJpaRepository extends JpaRepository<HolidayTypeEntity, Integer> { }
