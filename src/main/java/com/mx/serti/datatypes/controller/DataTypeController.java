package com.mx.serti.datatypes.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mx.serti.util.documentation.ApiDescriptions.*;
import static com.mx.serti.util.documentation.TagNames.*;
import static com.mx.serti.util.documentation.HttpOperations.*;
import static com.mx.serti.util.constants.Entity.*;
import com.mx.serti.datatypes.service.DataTypeService;
import com.mx.serti.datatypes.dto.DataTypeDTO;

import java.util.List;

@Tag(name = DATA_TYPE_API, description = DATA_TYPE_DESCRIPTION)
@RestController
@RequestMapping("/data-types")
public class DataTypeController {

    @Autowired
    DataTypeService dataTypeService;

    @GetMapping
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION + OF_DATA_TYPES)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<DataTypeDTO>> findAll() {
        return new ResponseEntity<>(dataTypeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + OF_DATA_TYPES)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataTypeDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(dataTypeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = HTTP_SAVE_OPERATION, description = HTTP_SAVE_OPERATION + DATA_TYPE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataTypeDTO> save(@RequestBody DataTypeDTO dataTypeDTO) {
        return new ResponseEntity<>(dataTypeService.save(dataTypeDTO), HttpStatus.OK);
    }

    @PostMapping("/list")
    @Operation(summary = HTTP_SAVE_LIST_OPERATION, description = HTTP_SAVE_LIST_OPERATION + DATA_TYPE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<DataTypeDTO>> saveList(@RequestBody List<DataTypeDTO> dataTypeDTOs) {
        return new ResponseEntity<>(dataTypeService.saveList(dataTypeDTOs), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = HTTP_UPDATE_OPERATION, description = HTTP_UPDATE_OPERATION + DATA_TYPE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataTypeDTO> update(@PathVariable Long id, @RequestBody DataTypeDTO dataTypeDTO) {
        return new ResponseEntity<>(dataTypeService.update(id, dataTypeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = HTTP_DELETE_BY_ID_OPERATION, description = HTTP_DELETE_BY_ID_OPERATION + DATA_TYPE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_NO_CONTENT, description = HTTP_DESCRIPTION_NO_CONTENT),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public void deleteById(@PathVariable Long id) {
        dataTypeService.deleteById(id);
    }

}
