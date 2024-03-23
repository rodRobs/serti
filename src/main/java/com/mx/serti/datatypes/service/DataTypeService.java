package com.mx.serti.datatypes.service;

import java.util.List;
import com.mx.serti.datatypes.dto.DataTypeDTO;

public interface DataTypeService {

    List<DataTypeDTO> findAll();

    DataTypeDTO findById(Long id);

    DataTypeDTO save(DataTypeDTO dataTypeDTO);

    List<DataTypeDTO> saveList(List<DataTypeDTO> dataTypeDTOs);

    DataTypeDTO update(Long id, DataTypeDTO dataTypeDTO);

    void deleteById(Long id);
}
