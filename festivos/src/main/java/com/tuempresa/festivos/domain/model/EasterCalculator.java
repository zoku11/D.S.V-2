package com.tuempresa.festivos.domain.model;

import java.time.LocalDate;
import java.time.Month;

public final class EasterCalculator {

    public static LocalDate computeEasterSunday(int year){
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int dias = d + ((2 * b + 4 * c + 6 * d + 5) % 7);
        
        LocalDate domingoDeRamos = LocalDate.of(year, Month.MARCH, 15).plusDays(dias);
        LocalDate domingoDePascua = domingoDeRamos.plusDays(7);
        return domingoDePascua;
    }
}
