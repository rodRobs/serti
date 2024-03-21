package com.mx.serti.pokeapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.mx.serti.util.documentation.TagNames.*;
import static com.mx.serti.util.documentation.HttpOperations.*;
import static com.mx.serti.util.documentation.ApiDescriptions.*;
import static com.mx.serti.util.constants.Entity.*;

import com.mx.serti.pokeapi.service.PokeApiService;
import com.mx.serti.pokeapi.dto.PokemonDTO;
import com.mx.serti.pokeapi.dto.SpecieDTO;
import com.mx.serti.pokeapi.dto.EvolutionDTO;

@Tag(name = POKE_API, description = POKE_API_DESCRIPTION)
@RestController
@RequestMapping("/poke-api")
public class PokeApiController {

    @Autowired
    PokeApiService pokeApiService;

    @GetMapping("/pokemons/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + OF_POKEMONS)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<PokemonDTO> findPokemonById(@PathVariable int id) {
        return new ResponseEntity<>(pokeApiService.findPokemonById(id), HttpStatus.OK);
    }

    @GetMapping("/species/{id}")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + SPECIE)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<SpecieDTO> findSpecieById(@PathVariable int id) {
        return new ResponseEntity<>(pokeApiService.findSpecieByPokemonId(id), HttpStatus.OK);
    }

    @GetMapping("/evolution")
    @Operation(summary = HTTP_FIND_BY_ID_OPERATION, description = HTTP_FIND_BY_ID_OPERATION + HTTP_FIND_EVOLUTION_CHAIN_OF_POKEMON)
    @ApiResponses(value = {
            @ApiResponse(responseCode = HTTP_CODE_OK, description = HTTP_DESCRIPTION_OK),
            @ApiResponse(responseCode = HTTP_CODE_ERROR_INTERNAL_SERVER, description = HTTP_DESCRIPTION_ERROR_INTERNAL_SERVER)
    })
    public ResponseEntity<EvolutionDTO> findSpecieById(@RequestParam String url) {
        return new ResponseEntity<>(pokeApiService.findEvolutionChainByUrl(url), HttpStatus.OK);
    }

}
