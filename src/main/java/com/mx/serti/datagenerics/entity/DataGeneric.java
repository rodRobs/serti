package com.mx.serti.datagenerics.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import com.mx.serti.datatypes.entity.DataType;
import com.mx.serti.datagenerics.dto.DataGenericDTO;

@Entity
@Table(name = "tbl_data_generic")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class DataGeneric implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dage_id")
    private Long dageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daty_id", nullable = false)
    private DataType dataType;

    @Column(name = "dage_name", nullable = false, length = 50, unique = true)
    private String dageName;

    @Column(name = "dage_url", length = 120)
    private String dageUrl;

    public DataGeneric(DataGenericDTO dataGeneric) {
        this.setDageId(dataGeneric.getDageId());
        this.setDageName(dataGeneric.getDageName());
        this.setDageName(dataGeneric.getDageName());
        this.setDageUrl(dataGeneric.getDageUrl());
    }

}
