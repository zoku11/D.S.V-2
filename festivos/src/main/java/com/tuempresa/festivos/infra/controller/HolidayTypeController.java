package com.tuempresa.festivos.infra.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.tuempresa.festivos.domain.model.HolidayType;
import com.tuempresa.festivos.domain.port.repository.HolidayTypeRepository;

@RestController
@RequestMapping("/holiday-types")
public class HolidayTypeController {
    private final HolidayTypeRepository typeRepository;

    public HolidayTypeController(HolidayTypeRepository typeRepository){
        this.typeRepository = typeRepository;
    }

    @GetMapping
    public List<HolidayType> getAll(){
        return typeRepository.findAll();
    }

    @PostMapping
    public HolidayType create(@RequestBody HolidayType type){
        return typeRepository.save(type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        typeRepository.deleteById(id);
    }
}