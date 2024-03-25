package com.mx.serti.pokemons.controller;

import com.mx.serti.pokemons.dto.PokemonDTO;
import com.mx.serti.pokemons.service.PokemonService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mx.serti.util.documentation.HttpOperations.*;

import java.util.List;

@Tag(name = "pokemons", description = "Servicio para realizar peticiones para pokemones")
@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping
    @Operation(summary = HTTP_FIND_ALL_OPERATION, description = HTTP_FIND_ALL_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<PokemonDTO>> findAll() {
        return new ResponseEntity<>(pokemonService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<PokemonDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(pokemonService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary = HTTP_SAVE_OPERATION, description = HTTP_SAVE_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_CODE_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<PokemonDTO> save(@RequestBody PokemonDTO pokemonDTO) {
        return new ResponseEntity<>(pokemonService.save(pokemonDTO), HttpStatus.CREATED);
    }

    @PostMapping("/list")
    @Operation(summary = HTTP_SAVE_LIST_OPERATION, description = HTTP_SAVE_LIST_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_CODE_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<List<PokemonDTO>> saveList(@RequestBody List<PokemonDTO> pokemonDTOs) {
        return new ResponseEntity<>(pokemonService.saveList(pokemonDTOs), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = HTTP_UPDATE_OPERATION, description = HTTP_UPDATE_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_CREATED, description = HTTP_DESCRIPTION_CREATED),
            @ApiResponse(responseCode = HTTP_CODE_BAD_REQUEST, description = HTTP_DESCRIPTION_BAD_REQUEST),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<PokemonDTO> update(@PathVariable Long id, @RequestBody PokemonDTO pokemonDTO) {
        return new ResponseEntity<>(pokemonService.update(id, pokemonDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = HTTP_DELETE_BY_ID_OPERATION, description = HTTP_DELETE_BY_ID_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_NO_CONTENT, description = HTTP_DESCRIPTION_NO_CONTENT),
            @ApiResponse(responseCode = HTTP_CODE_NOT_FOUND, description = HTTP_DESCRIPTION_NOT_FOUND),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public void deleteById(@PathVariable Long id) {
        pokemonService.deleteById(id);
    }

}
