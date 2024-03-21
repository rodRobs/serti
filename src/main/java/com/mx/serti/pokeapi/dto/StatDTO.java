package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class StatDTO {

    @JsonProperty("base_stat")
    private int baseStat;

    private int effort;

    private ValueDataDTO stat;

}
