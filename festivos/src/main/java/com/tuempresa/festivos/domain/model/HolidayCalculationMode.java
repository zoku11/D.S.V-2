package com.tuempresa.festivos.domain.model;

public enum HolidayCalculationMode {
    FIXED(1),               
    BRIDGE(2),             
    EASTER_BASED(3),        
    EASTER_BASED_BRIDGE(4); 

    private final int code;
    HolidayCalculationMode(int code){ this.code = code; }
    public int getCode(){ return code; }

    public static HolidayCalculationMode fromCode(int code){
        for (HolidayCalculationMode m : values()) if (m.code == code) return m;
        throw new IllegalArgumentException("Modo desconocido: " + code);
    }
}
