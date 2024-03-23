package com.mx.serti.datagenerics.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.serti.datagenerics.entity.DataGeneric;
import com.mx.serti.datatypes.dto.DataTypeDTO;
import com.mx.serti.datatypes.entity.DataType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.mx.serti.util.documentation.DataGenericDocumentation.*;
import static com.mx.serti.util.documentation.DataTypeDocumentation.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
@Schema(name = DATA_GENERIC_DTO, description = DATA_GENERIC_DTO_DESCRIPTION)
public class DataGenericDTO {

    @Schema(name = DAGE_ID, example = DAGE_ID_EXAMPLE_VALUE, description = DAGE_ID_DESCRIPTION)
    private Long dageId;

    @Schema(name = DATA_TYPE, description = DATA_TYPE_DESCRIPTION)
    private DataTypeDTO dataType;

    @Schema(name = NAME, example = NAME_EXAMPLE_VALUE, description = NAME_DESCRIPTION)
    @JsonProperty("name")
    private String dageName;

    @Schema(name = URL, example = URL_EXAMPLE_VALUE, description = URL_DESCRIPTION)
    @JsonProperty("url")
    private String dageUrl;

    public DataGenericDTO(DataGeneric dataGeneric) {
        this.setDageId(dataGeneric.getDageId());
        this.setDageName(dataGeneric.getDageName());
        this.setDataType(dataGeneric.getDataType());
        this.setDageUrl(dataGeneric.getDageUrl());
    }

    @JsonProperty
    public void setDataType(DataTypeDTO dataType) {
        this.dataType = dataType;
    }

    @JsonIgnore
    public void setDataType(DataType dataType) {
        this.dataType = DataTypeDTO.builder().datyId(dataType.getDatyId()).datyName(dataType.getDatyName()).build();
    }

}
