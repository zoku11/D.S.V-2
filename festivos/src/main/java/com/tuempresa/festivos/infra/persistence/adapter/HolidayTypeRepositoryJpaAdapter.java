package com.tuempresa.festivos.infra.persistence.adapter;

import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

import com.tuempresa.festivos.infra.persistence.repo.HolidayTypeJpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.HolidayTypeEntity;

@Component
public class HolidayTypeRepositoryJpaAdapter implements com.tuempresa.festivos.domain.port.repository.HolidayTypeRepository {
    private final HolidayTypeJpaRepository repo;

    public HolidayTypeRepositoryJpaAdapter(HolidayTypeJpaRepository repo){ this.repo = repo; }

    @Override
    public com.tuempresa.festivos.domain.model.HolidayType save(com.tuempresa.festivos.domain.model.HolidayType ht){
        HolidayTypeEntity e = HolidayTypeEntity.fromDomain(ht);
        HolidayTypeEntity s = repo.save(e);
        return s.toDomain();
    }

    @Override
    public Optional<com.tuempresa.festivos.domain.model.HolidayType> findById(Integer id){
        return repo.findById(id).map(HolidayTypeEntity::toDomain);
    }

    @Override
    public List<com.tuempresa.festivos.domain.model.HolidayType> findAll(){
        return repo.findAll().stream().map(HolidayTypeEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Integer id){ repo.deleteById(id); }
}
