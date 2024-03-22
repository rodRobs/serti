package com.mx.serti.datagenerics.dto;

import com.mx.serti.datagenerics.entity.DataGeneric;
import com.mx.serti.datatypes.dto.DataTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DataGenericDTO {

    private Long dageId;

    private DataTypeDTO dataType;

    private String dageName;

    private String dageUrl;

    public DataGenericDTO(DataGeneric dataGeneric) {
        this.setDageId(dataGeneric.getDageId());
        this.setDageName(dataGeneric.getDageName());
        this.setDageName(dataGeneric.getDageName());
        this.setDageUrl(dataGeneric.getDageUrl());
    }

}
