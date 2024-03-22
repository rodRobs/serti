package com.mx.serti.datagenerics.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mx.serti.datagenerics.service.DataGenericService;
import com.mx.serti.datagenerics.dto.DataGenericDTO;
import static com.mx.serti.util.documentation.ApiDescriptions.*;
import static com.mx.serti.util.documentation.TagNames.*;

import java.util.List;

@Tag(name = DATA_GENERIC, description = DATA_GENERIC_DESCRIPTION)
@RestController
@RequestMapping("/data-generics")
public class DataGenericController {

    @Autowired
    DataGenericService dataGenericService;

    @GetMapping
    public ResponseEntity<List<DataGenericDTO>> findAll() {
        return new ResponseEntity<>(dataGenericService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/data-type/{datyId}")
    public ResponseEntity<List<DataGenericDTO>> findByDataTypeId(@PathVariable Long datyId) {
        return new ResponseEntity<>(dataGenericService.findByDataTypeId(datyId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataGenericDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(dataGenericService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataGenericDTO> save(@RequestBody DataGenericDTO dataGenericDTO) {
        return new ResponseEntity<>(dataGenericService.save(dataGenericDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataGenericDTO> update(@PathVariable Long id, @RequestBody DataGenericDTO dataGenericDTO) {
        return new ResponseEntity<>(dataGenericService.update(id, dataGenericDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        dataGenericService.deleteById(id);
    }

}
