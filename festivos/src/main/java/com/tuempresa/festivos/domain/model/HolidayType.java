package com.tuempresa.festivos.domain.model;

import java.util.Objects;

public final class HolidayType {
    private final Integer id; // 1..4 según enunciado
    private final String name;
    private final HolidayCalculationMode mode;

    public HolidayType(Integer id, String name, HolidayCalculationMode mode){
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.mode = Objects.requireNonNull(mode);
    }
    public Integer getId(){ return id; }
    public String getName(){ return name; }
    public HolidayCalculationMode getMode(){ return mode; }

    @Override public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof HolidayType)) return false;
        return Objects.equals(id, ((HolidayType)o).id);
    }
    @Override public int hashCode(){ return Objects.hash(id); }
    @Override public String toString(){ return "HolidayType{id="+id+",name="+name+",mode="+mode+"}"; }
}
