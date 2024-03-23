package com.mx.serti.datatypes.service;

import com.mx.serti.datatypes.dto.DataTypeDTO;
import com.mx.serti.datatypes.entity.DataType;
import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.util.constants.Entity;
import com.mx.serti.util.constants.ErrorMessages;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.serti.datatypes.repository.DataTypeRepository;

import java.util.List;

import com.mx.serti.util.singletons.*;

@Service
@Slf4j
public class DataTypeServiceImpl implements DataTypeService {

    @Autowired
    DataTypeRepository dataTypeRepository;

    SingletonValidatorConstraint singletonValidatorConstraint = SingletonValidatorConstraint.getInstance();

    SingletonValidateFunctions singletonValidateFunctions = SingletonValidateFunctions.getInstance();

    @Override
    public List<DataTypeDTO> findAll() {
        List<DataType> dataTypes = dataTypeRepository.findAll();
        return entityListToDtoList(dataTypes);
    }

    public List<DataTypeDTO> entityListToDtoList(List<DataType> dataTypes) {
        return dataTypes.stream().map(DataTypeDTO::new).toList();
    }

    @Override
    public DataTypeDTO findById(Long id) {
        DataType dataType = dataTypeRepository.findById(id).orElseThrow(() -> {
           throw new NotFoundException(String.format(ErrorMessages.NOT_FOUND, Entity.DATA_TYPE) + id);
        });
        return entityToDto(dataType);
    }

    public DataTypeDTO entityToDto(DataType dataType) {
        return new DataTypeDTO(dataType);
    }

    @Override
    @Transactional
    public DataTypeDTO save(DataTypeDTO dataTypeDTO) {
        singletonValidatorConstraint.validate(dataTypeDTO);
        return saveInDatabase(dataTypeDTO);
    }

    public DataTypeDTO saveInDatabase(DataTypeDTO dataTypeDTO) {
        DataType dataType = dtoToEntity(dataTypeDTO);
        DataType dataTypeSave = dataTypeRepository.save(dataType);
        return entityToDto(dataTypeSave);
    }

    public DataType dtoToEntity(DataTypeDTO dataType) {
        return new DataType(dataType);
    }

    @Override
    @Transactional
    public List<DataTypeDTO> saveList(List<DataTypeDTO> dataTypeDTOs) {
        singletonValidatorConstraint.validateList(dataTypeDTOs);
        List<DataType> dataTypes = dataTypeDTOs.stream().map(DataType::new).toList();
        List<DataType> dataTypesSaved = dataTypeRepository.saveAll(dataTypes);
        return entityListToDtoList(dataTypesSaved);
    }

    @Override
    @Transactional
    public DataTypeDTO update(Long id, DataTypeDTO dataTypeDTO) {
        singletonValidatorConstraint.validate(dataTypeDTO);
        validate(id, dataTypeDTO);
        validateExistById(id);
        return saveInDatabase(dataTypeDTO);
    }

    public void validate(Long id, DataTypeDTO dataTypeDTO) {
        singletonValidateFunctions.nullId(dataTypeDTO.getDatyId());
        singletonValidateFunctions.idsMissmtachs(id, dataTypeDTO.getDatyId());
    }

    public void validateExistById(Long id) {
        boolean exist = existById(id);
        if (!exist)
            throw new NotFoundException(String.format(ErrorMessages.NOT_FOUND, Entity.DATA_TYPE) + id);
    }

    public boolean existById(Long id) {
        return dataTypeRepository.existsById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        validateExistById(id);
        dataTypeRepository.deleteById(id);
    }
}
