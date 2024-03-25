package com.mx.serti.pokemons.service;

import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.pokemons.entity.Pokemon;
import com.mx.serti.pokemons.repository.PokemonRepository;
import com.mx.serti.pokemons.dto.PokemonDTO;
import static com.mx.serti.util.constants.ErrorMessages.*;
import static com.mx.serti.util.constants.Entity.*;
import com.mx.serti.util.singletons.SingletonValidateFunctions;
import com.mx.serti.util.singletons.SingletonValidatorConstraint;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    SingletonValidatorConstraint singletonValidatorConstraint = SingletonValidatorConstraint.getInstance();

    SingletonValidateFunctions singletonValidateFunctions = SingletonValidateFunctions.getInstance();

    @Override
    public List<PokemonDTO> findAll() {
        log.debug("PokemonServiceImpl::findAll");
        return pokemonRepository.findAll().stream().map(PokemonDTO::new).toList();
    }

    @Override
    public PokemonDTO findById(Long id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> {
            log.error("PokemonServiceImpl::findById {}", id);
            throw new NotFoundException(String.format(NOT_FOUND, POKEMON) + id);
        });
        return entityToDto(pokemon);
    }

    public PokemonDTO entityToDto(Pokemon pokemon) {
        return new PokemonDTO(pokemon);
    }

    @Override
    @Transactional
    public PokemonDTO save(PokemonDTO pokemonDTO) {
        log.debug("PokemonServiceImpl::save {}", pokemonDTO);
        singletonValidatorConstraint.validate(pokemonDTO);
        return saveInDatabase(pokemonDTO);
    }

    public PokemonDTO saveInDatabase(PokemonDTO pokemonDTO) {
        Pokemon pokemon = dtoToEntity(pokemonDTO);
        Pokemon pokemonSaved = pokemonRepository.save(pokemon);
        return entityToDto(pokemonSaved);
    }

    public Pokemon dtoToEntity(PokemonDTO pokemon) {
        return new Pokemon(pokemon);
    }

    @Override
    public List<PokemonDTO> saveList(List<PokemonDTO> pokemonDTOs) {
        log.debug("PokemonServiceImpl::saveList {}", pokemonDTOs);
        List<Pokemon> pokemons = pokemonDTOs.stream().map(Pokemon::new).toList();
        return pokemons.stream().map(PokemonDTO::new).toList();
    }

    @Override
    @Transactional
    public PokemonDTO update(Long id, PokemonDTO pokemonDTO) {
        log.debug("PokemonServiceImpl::update {}, {}", id, pokemonDTO);
        singletonValidatorConstraint.validate(pokemonDTO);
        validate(id, pokemonDTO);
        existsId(id);
        return saveInDatabase(pokemonDTO);
    }

    public void validate(Long id, PokemonDTO pokemonDTO) {
        singletonValidateFunctions.nullId(pokemonDTO.getPokeId());
        singletonValidateFunctions.idsMissmtachs(id, pokemonDTO.getPokeId());
    }

    public void existsId(Long id) {
        boolean exists = pokemonRepository.existsById(id);
        if (!exists) {
            log.error("PokemonServiceImpl::existsId {}", id);
            throw new NotFoundException(String.format(NOT_FOUND, POKEMON) + id);
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.debug("PokemonServiceImpl::deleteById {}", id);
        pokemonRepository.deleteById(id);
    }
}
