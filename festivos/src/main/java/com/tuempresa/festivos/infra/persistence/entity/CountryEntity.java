package com.tuempresa.festivos.infra.persistence.entity;

import jakarta.persistence.*;
import com.tuempresa.festivos.domain.model.Country;

@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String name;

    public CountryEntity() {}
    public CountryEntity(Long id, String name){ this.id = id; this.name = name; }

    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }

    public Country toDomain(){
        return new Country(this.id, this.name);
    }

    public static CountryEntity fromDomain(com.tuempresa.festivos.domain.model.Country d){
        if (d == null) return null;
        return new CountryEntity(d.getId(), d.getName());
    }
}
