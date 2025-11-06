package com.tuempresa.festivos.application.service;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.tuempresa.festivos.domain.model.Holiday;
import com.tuempresa.festivos.domain.port.repository.HolidayRepository;

@Service
public class HolidayFinderService {
    private final HolidayRepository holidayRepository;

    public HolidayFinderService(HolidayRepository holidayRepository){
        this.holidayRepository = holidayRepository;
    }

    public List<LocalDate> listHolidayDatesForYear(Long countryId, int year){
        return holidayRepository.findByCountryId(countryId).stream()
            .map(h -> h.dateForYear(year))
            .sorted()
            .collect(Collectors.toList());
    }

    public List<Map.Entry<Holiday, LocalDate>> listHolidaysWithDates(Long countryId, int year){
        return holidayRepository.findByCountryId(countryId).stream()
            .map(h -> Map.entry(h, h.dateForYear(year)))
            .sorted(Comparator.comparing(Map.Entry::getValue))
            .collect(Collectors.toList());
    }

    public Optional<Holiday> findHolidayByDate(Long countryId, LocalDate date){
        return holidayRepository.findByCountryIdAndDate(countryId, date);
    }
}