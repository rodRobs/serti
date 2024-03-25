package com.mx.serti.chainevolutions.controller;

import com.mx.serti.chainevolutions.dto.ChainEvolutionDTO;
import com.mx.serti.chainevolutions.service.ChainEvolutionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mx.serti.util.documentation.HttpOperations.*;
import static com.mx.serti.util.constants.Entity.*;

import java.util.List;

@Tag(name = "chain-evolutions", description = "Servicio para realizar peticiones de las cadenas de evoluciones correspondientes a los pokemones")
@RestController
@RequestMapping("/chain-evolutions")
public class ChainEvolutionController {

    @Autowired
    ChainEvolutionService chainEvolutionService;

    @GetMapping
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION + OF_CHAIN_EVOLUTIONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<ChainEvolutionDTO>> findAll() {
        return new ResponseEntity<>(chainEvolutionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/pokemon/{pokeId}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + POKEMON)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<ChainEvolutionDTO> findByPokemonId(@PathVariable Long pokeId) {
        return new ResponseEntity<>(chainEvolutionService.findByPokeId(pokeId), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + OF_CHAIN_EVOLUTIONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<ChainEvolutionDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(chainEvolutionService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = HTTP_SAVE_OPERATION, description = HTTP_SAVE_OPERATION + OF_CHAIN_EVOLUTIONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<ChainEvolutionDTO> save(@RequestBody ChainEvolutionDTO chainEvolutionDTO) {
        return new ResponseEntity<>(chainEvolutionService.save(chainEvolutionDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = HTTP_SAVE_OPERATION, description = HTTP_SAVE_OPERATION + OF_CHAIN_EVOLUTIONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<ChainEvolutionDTO> update(@PathVariable Long id, @RequestBody ChainEvolutionDTO chainEvolutionDTO) {
        return new ResponseEntity<>(chainEvolutionService.update(id, chainEvolutionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = HTTP_DELETE_BY_ID_OPERATION, description = HTTP_DELETE_BY_ID_OPERATION + OF_CHAIN_EVOLUTIONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_NO_CONTENT, description = HTTP_DESCRIPTION_NO_CONTENT),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public void deleteById(@PathVariable Long id) {
        chainEvolutionService.deleteById(id);
    }

}
