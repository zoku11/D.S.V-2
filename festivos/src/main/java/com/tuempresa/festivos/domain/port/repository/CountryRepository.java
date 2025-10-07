package com.tuempresa.festivos.domain.port.repository;

import com.tuempresa.festivos.domain.model.Country;
import java.util.List;
import java.util.Optional;

public interface CountryRepository {
    Country save(Country country);
    Optional<Country> findById(Long id);
    List<Country> findAll();
    void deleteById(Long id);
}
