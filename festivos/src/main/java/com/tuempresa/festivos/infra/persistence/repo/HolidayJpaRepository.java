package com.tuempresa.festivos.infra.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.HolidayEntity;
import java.util.List;

public interface HolidayJpaRepository extends JpaRepository<HolidayEntity, Long> {
    
    List<HolidayEntity> findByCountry_Id(Long countryId);
}
