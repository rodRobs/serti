package com.mx.serti.pokeapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class AbilityDTO {

    private ValueDataDTO ability;

    @JsonProperty("is_hidden")
    private boolean isHidden;

    private int slot;


}
