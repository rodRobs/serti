package com.mx.serti.uris.controller;

import com.mx.serti.uris.dto.UriDTO;
import com.mx.serti.uris.service.UriService;
import com.mx.serti.util.constants.Entity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mx.serti.util.documentation.TagNames.*;
import static com.mx.serti.util.documentation.HttpOperations.*;
import static com.mx.serti.util.documentation.ApiDescriptions.*;

import java.util.List;

@Tag(name = URI_API, description = URI_DESCRIPTION)
@RestController
@RequestMapping("/uris")
public class UriController {

    @Autowired
    UriService requestService;

    @GetMapping
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION + Entity.OF_URIS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<UriDTO>> findAll() {
        return new ResponseEntity<>(requestService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION + Entity.OF_URIS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<UriDTO> findById(@PathVariable @Parameter(name = "id", description = "Identificador del registro") int id) {
        return new ResponseEntity<>(requestService.findById(id), HttpStatus.OK);
    }

}
