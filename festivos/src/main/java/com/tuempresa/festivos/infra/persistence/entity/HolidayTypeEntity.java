package com.tuempresa.festivos.infra.persistence.entity;

import jakarta.persistence.*;
import com.tuempresa.festivos.domain.model.HolidayType;
import com.tuempresa.festivos.domain.model.HolidayCalculationMode;

@Entity
@Table(name = "holiday_type")
public class HolidayTypeEntity {
    @Id
    private Integer id;

    @Column(nullable=false)
    private String name;

   
    @Column(name = "mode", nullable = false)
    private Integer mode;

    public HolidayTypeEntity() {}
    public HolidayTypeEntity(Integer id, String name, Integer mode){
        this.id = id; this.name = name; this.mode = mode;
    }

    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public Integer getMode(){ return mode; }
    public void setMode(Integer mode){ this.mode = mode; }

    public HolidayType toDomain(){
        HolidayCalculationMode calcMode = HolidayCalculationMode.fromCode(this.mode);
        return new HolidayType(this.id, this.name, calcMode);
    }

    public static HolidayTypeEntity fromDomain(HolidayType d){
        if (d == null) return null;
        return new HolidayTypeEntity(d.getId(), d.getName(), d.getMode().getCode());
    }
}
