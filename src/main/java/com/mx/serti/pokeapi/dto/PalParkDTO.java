package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PalParkDTO {

    private ValueDataDTO area;
    @JsonProperty("base_score")
    private int baseScore;
    private int rate;

}
