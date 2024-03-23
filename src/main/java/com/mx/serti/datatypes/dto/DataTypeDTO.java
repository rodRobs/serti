package com.mx.serti.datatypes.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.mx.serti.datatypes.entity.DataType;
import static com.mx.serti.util.documentation.DataTypeDocumentation.*;
import static com.mx.serti.util.constants.ErrorMessages.*;
import static com.mx.serti.util.constants.Numbers.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DataTypeDTO {

    @Schema(name = DATY_ID, example = DATY_ID_EXAMPLE_VALUE, description = DATY_ID_DESCRIPTION)
    private Long datyId;

    @NotNull(message = DATY_NAME_DESCRIPTION + IS_REQUIRED)
    @Size(max = 60, message = DATY_NAME_DESCRIPTION + MINUS_OF + SIXTY + CHARACTERS)
    @Schema(name = DATY_NAME, example = DATY_NAME_EXAMPLE_VALUE, description = DATY_NAME_DESCRIPTION, maxLength = 60)
    private String datyName;

    public DataTypeDTO(DataType dataType) {
        this.setDatyId(dataType.getDatyId());
        this.setDatyName(dataType.getDatyName());
    }

}
