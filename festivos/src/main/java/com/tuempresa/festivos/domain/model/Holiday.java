package com.tuempresa.festivos.domain.model;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public final class Holiday {
    private final Long id;
    private final Long countryId;   
    private final String name;
    private final Integer day;      
    private final Integer month;    
    private final Integer easterOffset; 
    private final HolidayType type;

    public Holiday(Long id, Long countryId, String name,
                   Integer day, Integer month, Integer easterOffset,
                   HolidayType type){
        this.id = id;
        this.countryId = Objects.requireNonNull(countryId);
        this.name = Objects.requireNonNull(name);
        this.day = day;
        this.month = month;
        this.easterOffset = easterOffset;
        this.type = Objects.requireNonNull(type);
    }

    public Long getId(){ return id; }
    public Long getCountryId(){ return countryId; }
    public String getName(){ return name; }
    public Integer getDay(){ return day; }
    public Integer getMonth(){ return month; }
    public Integer getEasterOffset(){ return easterOffset; }
    public HolidayType getType(){ return type; }

    
    public LocalDate dateForYear(int year){
        HolidayCalculationMode mode = type.getMode();
        try {
            switch(mode){
                case FIXED:
                    return LocalDate.of(year, Month.of(month), day);
                case BRIDGE: {
                    LocalDate d = LocalDate.of(year, Month.of(month), day);
                    return moveToNextMondayIfNeeded(d);
                }
                case EASTER_BASED: {
                    LocalDate easter = EasterCalculator.computeEasterSunday(year);
                    return easter.plusDays(easterOffset == null ? 0 : easterOffset);
                }
                case EASTER_BASED_BRIDGE: {
                    LocalDate easter = EasterCalculator.computeEasterSunday(year);
                    LocalDate d = easter.plusDays(easterOffset == null ? 0 : easterOffset);
                    return moveToNextMondayIfNeeded(d);
                }
                default:
                    throw new IllegalStateException("Modo no soportado: " + mode);
            }
        } catch (DateTimeException ex){
            throw new IllegalArgumentException("Definición de festivo inválida para año " + year + ": " + ex.getMessage(), ex);
        }
    }

    private LocalDate moveToNextMondayIfNeeded(LocalDate d){
        DayOfWeek dow = d.getDayOfWeek();
        
        int daysToAdd = (8 - dow.getValue()) % 7;
        return d.plusDays(daysToAdd);
    }

    @Override public String toString(){ return "Holiday{id="+id+",name="+name+",type="+type+"}"; }
}
