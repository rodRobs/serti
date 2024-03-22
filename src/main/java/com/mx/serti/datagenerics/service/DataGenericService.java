package com.mx.serti.datagenerics.service;

import java.util.List;

import com.mx.serti.datagenerics.dto.DataGenericDTO;

public interface DataGenericService {

    List<DataGenericDTO> findAll();

    List<DataGenericDTO> findByDataTypeId(Long datyId);

    DataGenericDTO findById(Long id);

    DataGenericDTO save(DataGenericDTO dataGenericDTO);

    DataGenericDTO update(Long id, DataGenericDTO dataGenericDTO);

    void deleteById(Long id);

}
