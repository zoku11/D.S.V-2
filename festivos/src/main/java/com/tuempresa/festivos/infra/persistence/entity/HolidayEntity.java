package com.tuempresa.festivos.infra.persistence.entity;

import jakarta.persistence.*;
import com.tuempresa.festivos.domain.model.Holiday;

@Entity
@Table(name = "holiday")
public class HolidayEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @Column(nullable = false)
    private String name;

    
    private Integer day;
    private Integer month;

    @Column(name = "easter_offset")
    private Integer easterOffset;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private HolidayTypeEntity type;

    public HolidayEntity() {}

    
    public Long getId(){ return id; }
    public void setId(Long id){ this.id = id; }
    public CountryEntity getCountry(){ return country; }
    public void setCountry(CountryEntity country){ this.country = country; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public Integer getDay(){ return day; }
    public void setDay(Integer day){ this.day = day; }
    public Integer getMonth(){ return month; }
    public void setMonth(Integer month){ this.month = month; }
    public Integer getEasterOffset(){ return easterOffset; }
    public void setEasterOffset(Integer easterOffset){ this.easterOffset = easterOffset; }
    public HolidayTypeEntity getType(){ return type; }
    public void setType(HolidayTypeEntity type){ this.type = type; }

    public Holiday toDomain(){
        Long countryId = (country != null) ? country.getId() : null;
        return new Holiday(
            this.id,
            countryId,
            this.name,
            this.day,
            this.month,
            this.easterOffset,
            this.type != null ? this.type.toDomain() : null
        );
    }

    public static HolidayEntity fromDomain(com.tuempresa.festivos.domain.model.Holiday d, CountryEntity countryEntity, HolidayTypeEntity typeEntity){
        HolidayEntity e = new HolidayEntity();
        e.setId(d.getId());
        e.setCountry(countryEntity);
        e.setName(d.getName());
        e.setDay(d.getDay());
        e.setMonth(d.getMonth());
        e.setEasterOffset(d.getEasterOffset());
        e.setType(typeEntity);
        return e;
    }
}
