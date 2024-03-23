package com.mx.serti.datagenerics.service;

import com.mx.serti.datatypes.dto.DataTypeDTO;
import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.util.singletons.SingletonValidateFunctions;
import com.mx.serti.util.singletons.SingletonValidatorConstraint;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.serti.datagenerics.repository.DataGenericRepository;
import com.mx.serti.datagenerics.dto.DataGenericDTO;
import com.mx.serti.datagenerics.entity.DataGeneric;

import static com.mx.serti.util.constants.ErrorMessages.*;
import static com.mx.serti.util.constants.Entity.*;

import java.util.List;

@Service
@Slf4j
public class DataGenericServiceImpl implements DataGenericService {

    @Autowired
    DataGenericRepository dataGenericRepository;

    SingletonValidatorConstraint singletonValidatorConstraint = SingletonValidatorConstraint.getInstance();

    SingletonValidateFunctions singletonValidateFunctions = SingletonValidateFunctions.getInstance();

    @Override
    public List<DataGenericDTO> findAll() {
        List<DataGeneric> dataGenerics = dataGenericRepository.findAll();
        return entityListToDtoList(dataGenerics);
    }

    public List<DataGenericDTO> entityListToDtoList(List<DataGeneric> dataGenerics) {
        return dataGenerics.stream().map(DataGenericDTO::new).toList();
    }

    @Override
    public List<DataGenericDTO> findByDataTypeId(Long id) {
        return dataGenericRepository.findByDataTypeDatyId(id).stream().map(DataGenericDTO::new).toList();
    }

    @Override
    public DataGenericDTO findById(Long id) {
        DataGeneric dataGeneric = dataGenericRepository.findById(id).orElseThrow(() -> {
            notFoundMessage(id);
            return null;
        });
        return entityToDTO(dataGeneric);
    }

    public void notFoundMessage(Long id) {
        throw new NotFoundException(String.format(NOT_FOUND, DATA_GENERIC) + id);
    }

    public DataGenericDTO entityToDTO(DataGeneric dataGeneric) {
        return new DataGenericDTO(dataGeneric);
    }

    @Override
    @Transactional
    public DataGenericDTO save(DataGenericDTO dataGenericDTO) {
        singletonValidatorConstraint.validate(dataGenericDTO);
        return saveInDatabase(dataGenericDTO);
    }

    public DataGenericDTO saveInDatabase(DataGenericDTO dataGenericDTO) {
        DataGeneric dataGeneric = dtoToEntity(dataGenericDTO);
        DataGeneric dataGenericSaved = dataGenericRepository.save(dataGeneric);
        return entityToDTO(dataGenericSaved);
    }

    @Override
    public List<DataGenericDTO> saveList(Long id, List<DataGenericDTO> dataGenericDTOs) {
        singletonValidatorConstraint.validateList(dataGenericDTOs);
        DataTypeDTO dataTypeDTO = DataTypeDTO.builder().datyId(id).build();
        dataGenericDTOs.forEach(dg -> dg.setDataType(dataTypeDTO));
        List<DataGeneric> dataGenerics = dataGenericDTOs.stream().map(DataGeneric::new).toList();
        List<DataGeneric> dataGenericsSaved = dataGenericRepository.saveAll(dataGenerics);
        return entityListToDtoList(dataGenericsSaved);
    }

    public DataGeneric dtoToEntity(DataGenericDTO dataGeneric) {
        return new DataGeneric(dataGeneric);
    }

    @Override
    @Transactional
    public DataGenericDTO update(Long id, DataGenericDTO dataGenericDTO) {
        singletonValidatorConstraint.validate(dataGenericDTO);
        validate(id, dataGenericDTO);
        existsValid(id);
        return saveInDatabase(dataGenericDTO);
    }

    public void validate(Long id, DataGenericDTO dataGenericDTO) {
        singletonValidateFunctions.nullId(dataGenericDTO.getDageId());
        singletonValidateFunctions.idsMissmtachs(id, dataGenericDTO.getDageId());
    }

    public void existsValid(Long id) {
        boolean idExists = dataGenericRepository.existsById(id);
        if (!idExists)
            notFoundMessage(id);
    }

    @Override
    public void deleteById(Long id) {
        existsValid(id);
        dataGenericRepository.deleteById(id);
    }
}
