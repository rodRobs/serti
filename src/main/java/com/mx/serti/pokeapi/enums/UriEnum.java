package com.mx.serti.pokeapi.enums;

public enum UriEnum {
    
    FIND_BY_ID(1), FIND_SPECIE(2), FIND_EVOLUTION(3);

    private final int id;

    UriEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
}
