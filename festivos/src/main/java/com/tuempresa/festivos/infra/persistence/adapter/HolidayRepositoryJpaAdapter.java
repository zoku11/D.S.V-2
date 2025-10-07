package com.tuempresa.festivos.infra.persistence.adapter;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import com.tuempresa.festivos.domain.model.Holiday;
import com.tuempresa.festivos.domain.port.repository.HolidayRepository;
import com.tuempresa.festivos.infra.persistence.repo.HolidayJpaRepository;
import com.tuempresa.festivos.infra.persistence.repo.CountryJpaRepository;
import com.tuempresa.festivos.infra.persistence.repo.HolidayTypeJpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.HolidayEntity;
import com.tuempresa.festivos.infra.persistence.entity.CountryEntity;
import com.tuempresa.festivos.infra.persistence.entity.HolidayTypeEntity;

@Component
public class HolidayRepositoryJpaAdapter implements HolidayRepository {

    private final HolidayJpaRepository holidayJpa;
    private final CountryJpaRepository countryJpa;
    private final HolidayTypeJpaRepository holidayTypeJpa;

    public HolidayRepositoryJpaAdapter(HolidayJpaRepository holidayJpa,
                                       CountryJpaRepository countryJpa,
                                       HolidayTypeJpaRepository holidayTypeJpa){
        this.holidayJpa = holidayJpa;
        this.countryJpa = countryJpa;
        this.holidayTypeJpa = holidayTypeJpa;
    }

    @Override
    @Transactional
    public Holiday save(Holiday holiday) {
        CountryEntity countryEntity = countryJpa.findById(holiday.getCountryId())
            .orElseThrow(() -> new IllegalArgumentException("Country not found: " + holiday.getCountryId()));
        HolidayTypeEntity typeEntity = holidayTypeJpa.findById(holiday.getType().getId())
            .orElseThrow(() -> new IllegalArgumentException("HolidayType not found: " + holiday.getType().getId()));

        HolidayEntity entity = HolidayEntity.fromDomain(holiday, countryEntity, typeEntity);
        HolidayEntity saved = holidayJpa.save(entity);
        return saved.toDomain();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Holiday> findById(Long id) {
        return holidayJpa.findById(id).map(HolidayEntity::toDomain);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Holiday> findAll() {
        return holidayJpa.findAll().stream().map(HolidayEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        holidayJpa.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Holiday> findByCountryId(Long countryId) {
        return holidayJpa.findByCountry_Id(countryId).stream()
                .map(HolidayEntity::toDomain)
                .collect(Collectors.toList());
    }

    
    @Override
    @Transactional(readOnly = true)
    public List<Holiday> findByCountryIdAndYear(Long countryId, int year) {
        List<Holiday> holidays = findByCountryId(countryId);
        // ordena por la fecha resultante en ese año
        return holidays.stream()
                .sorted(Comparator.comparing(h -> h.dateForYear(year)))
                .collect(Collectors.toList());
    }

    
    @Override
    @Transactional(readOnly = true)
    public Optional<Holiday> findByCountryIdAndDate(Long countryId, LocalDate date) {
        int year = date.getYear();
        return findByCountryIdAndYear(countryId, year).stream()
                .filter(h -> h.dateForYear(year).equals(date))
                .findFirst();
    }
}
