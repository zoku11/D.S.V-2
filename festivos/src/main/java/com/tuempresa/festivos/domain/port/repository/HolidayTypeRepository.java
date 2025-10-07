package com.tuempresa.festivos.domain.port.repository;

import com.tuempresa.festivos.domain.model.HolidayType;
import java.util.List;
import java.util.Optional;

public interface HolidayTypeRepository {
    HolidayType save(HolidayType holidayType);
    Optional<HolidayType> findById(Integer id);
    List<HolidayType> findAll();
    void deleteById(Integer id);
}
