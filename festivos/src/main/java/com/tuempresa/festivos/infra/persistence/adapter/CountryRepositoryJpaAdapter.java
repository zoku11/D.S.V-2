package com.tuempresa.festivos.infra.persistence.adapter;

import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

import com.tuempresa.festivos.infra.persistence.repo.CountryJpaRepository;
import com.tuempresa.festivos.infra.persistence.entity.CountryEntity;

@Component
public class CountryRepositoryJpaAdapter implements com.tuempresa.festivos.domain.port.repository.CountryRepository {
    private final CountryJpaRepository repo;

    public CountryRepositoryJpaAdapter(CountryJpaRepository repo){ this.repo = repo; }

    @Override
    public com.tuempresa.festivos.domain.model.Country save(com.tuempresa.festivos.domain.model.Country c){ 
        CountryEntity e = CountryEntity.fromDomain(c);
        CountryEntity s = repo.save(e);
        return s.toDomain();
    }

    @Override
    public Optional<com.tuempresa.festivos.domain.model.Country> findById(Long id){
        return repo.findById(id).map(CountryEntity::toDomain);
    }

    @Override
    public List<com.tuempresa.festivos.domain.model.Country> findAll(){
        return repo.findAll().stream().map(CountryEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id){ repo.deleteById(id); }
}
