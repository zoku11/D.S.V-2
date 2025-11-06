package com.tuempresa.festivos.infra.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import com.tuempresa.festivos.application.service.HolidayFinderService;
import com.tuempresa.festivos.domain.model.Holiday;
import com.tuempresa.festivos.domain.port.repository.HolidayRepository;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final HolidayRepository holidayRepository;
    private final HolidayFinderService finderService;

    public HolidayController(HolidayRepository holidayRepository,
                             HolidayFinderService finderService){
        this.holidayRepository = holidayRepository;
        this.finderService = finderService;
    }

    @GetMapping
    public List<Holiday> getAll(){
        return holidayRepository.findAll();
    }

    @PostMapping
    public Holiday create(@RequestBody Holiday holiday){
        return holidayRepository.save(holiday);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        holidayRepository.deleteById(id);
    }

    @GetMapping("/country/{countryId}/year/{year}")
    public List<Map.Entry<Holiday, LocalDate>> getHolidaysForYear(
            @PathVariable Long countryId,
            @PathVariable int year){
        return finderService.listHolidaysWithDates(countryId, year);
    }

    @GetMapping("/country/{countryId}/is-holiday")
    public boolean isHoliday(
            @PathVariable Long countryId,
            @RequestParam String date){
        LocalDate d = LocalDate.parse(date);
        return finderService.findHolidayByDate(countryId, d).isPresent();
    }
}