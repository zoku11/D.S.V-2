package com.tuempresa.festivos.domain.model;

import java.util.Objects;

public final class Country {
    private final Long id;
    private final String name;

    public Country(Long id, String name){
        this.id = id;
        this.name = Objects.requireNonNull(name);
    }
    public Long getId(){ return id; }
    public String getName(){ return name; }

    @Override public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Country)) return false;
        Country c = (Country)o;
        return Objects.equals(id, c.id);
    }
    @Override public int hashCode(){ return Objects.hash(id); }
    @Override public String toString(){ return "Country{id="+id+",name="+name+"}"; }
}
