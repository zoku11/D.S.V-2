package com.tuempresa.festivos.domain.port.repository;

import com.tuempresa.festivos.domain.model.Holiday;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface HolidayRepository {
    Holiday save(Holiday holiday);
    Optional<Holiday> findById(Long id);
    List<Holiday> findAll();
    void deleteById(Long id);


    List<Holiday> findByCountryId(Long countryId);
    
    List<Holiday> findByCountryIdAndYear(Long countryId, int year);
    Optional<Holiday> findByCountryIdAndDate(Long countryId, LocalDate date);
}
