package com.tuempresa.festivos.infra.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tuempresa.festivos.domain.model.Country;
import com.tuempresa.festivos.domain.port.repository.CountryRepository;

@RestController
@RequestMapping("/countries")
public class CountryController {
    private final CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public List<Country> getAll(){
        return countryRepository.findAll();
    }

    @PostMapping
    public Country create(@RequestBody Country country){
        return countryRepository.save(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        countryRepository.deleteById(id);
    }
}
