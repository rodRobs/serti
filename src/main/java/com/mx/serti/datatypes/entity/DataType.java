package com.mx.serti.datatypes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import com.mx.serti.datatypes.dto.DataTypeDTO;

@Entity
@Table(name = "tbl_data_type")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DataType implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "daty_id")
    private Long datyId;

    @Column(name = "daty_name", length = 60, unique = true)
    private String datyName;

    public DataType(DataTypeDTO dataType) {
        this.setDatyId(dataType.getDatyId());
        this.setDatyName(dataType.getDatyName());
    }

}
