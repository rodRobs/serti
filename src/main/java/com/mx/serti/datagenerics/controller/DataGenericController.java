package com.mx.serti.datagenerics.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.serti.datagenerics.service.DataGenericService;
import com.mx.serti.datagenerics.dto.DataGenericDTO;

import static com.mx.serti.util.constants.Entity.*;
import static com.mx.serti.util.documentation.ApiDescriptions.*;
import static com.mx.serti.util.documentation.HttpOperations.*;
import static com.mx.serti.util.documentation.TagNames.*;

import java.util.List;

@Tag(name = DATA_GENERIC_API, description = DATA_GENERIC_DESCRIPTION)
@RestController
@RequestMapping("/data-generics")
public class DataGenericController {

    @Autowired
    DataGenericService dataGenericService;

    @GetMapping
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<DataGenericDTO>> findAll() {
        return new ResponseEntity<>(dataGenericService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/data-type/{datyId}")
    @Operation(summary = HTTP_FIND_BY_DATA_TYPE_ID_OPERATION, description = HTTP_FIND_BY_DATA_TYPE_ID_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<DataGenericDTO>> findByDataTypeId(@PathVariable Long datyId) {
        return new ResponseEntity<>(dataGenericService.findByDataTypeId(datyId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataGenericDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(dataGenericService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = HTTP_SAVE_OPERATION, description = HTTP_SAVE_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataGenericDTO> save(@RequestBody DataGenericDTO dataGenericDTO) {
        return new ResponseEntity<>(dataGenericService.save(dataGenericDTO), HttpStatus.CREATED);
    }

    @PostMapping("/list/{id}")
    @Operation(summary = HTTP_SAVE_LIST_OPERATION, description = HTTP_SAVE_LIST_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<DataGenericDTO>> saveList(@PathVariable Long id, @RequestBody List<DataGenericDTO> dataGenericDTO) {
        return new ResponseEntity<>(dataGenericService.saveList(id, dataGenericDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = HTTP_UPDATE_OPERATION, description = HTTP_UPDATE_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<DataGenericDTO> update(@PathVariable Long id, @RequestBody DataGenericDTO dataGenericDTO) {
        return new ResponseEntity<>(dataGenericService.update(id, dataGenericDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = HTTP_DELETE_BY_ID_OPERATION, description = HTTP_DELETE_BY_ID_OPERATION + OF_DATA_GENERICS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_NO_CONTENT, description = HTTP_DESCRIPTION_NO_CONTENT),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_CODE_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public void delete(@PathVariable Long id) {
        dataGenericService.deleteById(id);
    }

}
