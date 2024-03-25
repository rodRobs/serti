package com.mx.serti.chainevolutions.service;

import com.mx.serti.chainevolutions.dto.ChainEvolutionDTO;
import com.mx.serti.chainevolutions.entity.ChainEvolution;
import com.mx.serti.chainevolutions.repository.ChainEvolutionRepository;
import com.mx.serti.exceptions.NotFoundException;
import com.mx.serti.pokeapi.dto.EvolvesToDTO;
import com.mx.serti.pokeapi.dto.ValueDataDTO;
import com.mx.serti.pokemons.dto.PokemonDTO;
import com.mx.serti.util.generics.GenericPokeApiLocalWebClient;
import com.mx.serti.util.generics.GenericPokeApiWebClient;
import com.mx.serti.util.singletons.SingletonValidateFunctions;
import com.mx.serti.util.singletons.SingletonValidatorConstraint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mx.serti.util.constants.ErrorMessages.*;
import static com.mx.serti.util.constants.Entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ChainEvolutionServiceImpl implements ChainEvolutionService {

    @Autowired
    ChainEvolutionRepository chainEvolutionRepository;

    @Autowired
    GenericPokeApiLocalWebClient genericPokeApiLocalWebClient;

    @Autowired
    GenericPokeApiWebClient genericPokeApiWebClient;

    SingletonValidatorConstraint singletonValidatorConstraint = SingletonValidatorConstraint.getInstance();

    SingletonValidateFunctions singletonValidateFunctions = SingletonValidateFunctions.getInstance();

    @Override
    public List<ChainEvolutionDTO> findAll() {
        log.debug("ChainEvolutionServiceImpl::findAll");
        List<ChainEvolution> chainEvolutions = chainEvolutionRepository.findAll();
        return entityListToDtoList(chainEvolutions);
    }

    public List<ChainEvolutionDTO> entityListToDtoList(List<ChainEvolution> chainEvolutions) {
        return chainEvolutions.stream().map(ChainEvolutionDTO::new).toList();
    }

    @Override
    public ChainEvolutionDTO findByPokeId(Long pokeId) {
        log.debug("ChainEvolutionServiceImpl::findByPokeId {}", pokeId);
        ChainEvolution chainEvolution = chainEvolutionRepository.findByPokemonsPokeId(pokeId);
        throwMessageErrorByPokemonId(pokeId, chainEvolution);
        return entityToDto(chainEvolution);
    }

    public void throwMessageErrorByPokemonId(Long pokeId, ChainEvolution chainEvolution) {
        if (Objects.isNull(chainEvolution)) {
            log.error("throwMessageErrorByPokemonId {}, {}", pokeId, chainEvolution);
            throw new NotFoundException(String.format(NOT_FOUND_BY_POKEMON, CHAIN_EVOLUTION, pokeId));
        }
    }

    @Override
    public ChainEvolutionDTO findById(Long id) {
        log.debug("ChainEvolutionServiceImpl::findById {}", id);
        ChainEvolution chainEvolution = chainEvolutionRepository.findById(id).orElseThrow(() -> {
            log.error("ChainEvolutionServiceImpl::findById {}", id);
            throwMessageError(id);
            return null;
        });
        return entityToDto(chainEvolution);
    }

    public void throwMessageError(Long id) {
        throw new NotFoundException(String.format(NOT_FOUND, CHAIN_EVOLUTION) + id);
    }

    public ChainEvolutionDTO entityToDto(ChainEvolution chainEvolution) {
        return new ChainEvolutionDTO(chainEvolution);
    }

    @Override
    public ChainEvolutionDTO save(ChainEvolutionDTO chainEvolutionDTO) {
        log.debug("ChainEvolutionServiceImpl::save {}", chainEvolutionDTO);
        singletonValidatorConstraint.validate(chainEvolutionDTO);
        return saveInDatabase(chainEvolutionDTO);
    }

    public ChainEvolutionDTO saveInDatabase(ChainEvolutionDTO chainEvolutionDTO) {
        ChainEvolution chainEvolution = dtoToEntity(chainEvolutionDTO);
        ChainEvolution chainEvolutionSaved = chainEvolutionRepository.save(chainEvolution);
        return entityToDto(chainEvolutionSaved);
    }

    public ChainEvolution dtoToEntity(ChainEvolutionDTO chainEvolution) {
        return new ChainEvolution(chainEvolution);
    }

    @Override
    public ChainEvolutionDTO update(Long id, ChainEvolutionDTO chainEvolutionDTO) {
        log.debug("ChainEvolutionServiceImpl::update {}, {}", id, chainEvolutionDTO);
        validate(id, chainEvolutionDTO);
        singletonValidatorConstraint.validate(chainEvolutionDTO);
        return saveInDatabase(chainEvolutionDTO);
    }

    public void validate(Long id, ChainEvolutionDTO chainEvolutionDTO) {
        singletonValidateFunctions.nullId(chainEvolutionDTO.getChevId());
        singletonValidateFunctions.idsMissmtachs(id, chainEvolutionDTO.getChevId());
        existsId(id);
    }

    public void existsId(Long id) {
        boolean exists = chainEvolutionRepository.existsById(id);
        if (!exists) {
            log.error("ChainEvolutionServiceImpl::existsId {}", id);
            throwMessageError(id);
        }
    }

    @Override
    public void deleteById(Long id) {
        log.debug("ChainEvolutionServiceImpl::deleteById {}", id);
        existsId(id);
        chainEvolutionRepository.deleteById(id);
    }

    public List<PokemonDTO> getPokemonObjectToSave(Long id) {
        com.mx.serti.pokeapi.dto.PokemonDTO pokemonBase = findPokmeonByPokemonId(id);
        List<com.mx.serti.pokeapi.dto.PokemonDTO> pokemons = pokemonsToFind(pokemonBase);
        pokemons.add(pokemonBase);
        List<PokemonDTO> pokemonDTOList = pokemons.stream().map(PokemonDTO::new).toList();
        pokemonDTOList = saveListPokemon(pokemonDTOList);
        return pokemonDTOList;
    }

    public com.mx.serti.pokeapi.dto.PokemonDTO findPokmeonByPokemonId(Long id) {
        return genericPokeApiLocalWebClient.findPokemonById(id);
    }

    public List<com.mx.serti.pokeapi.dto.PokemonDTO> pokemonsToFind(com.mx.serti.pokeapi.dto.PokemonDTO pokemonDTO) {
        List<ValueDataDTO> species = new ArrayList<>();
        EvolvesToDTO evolvesToDTO = pokemonDTO.getSpecie().getEvolution().getChain();
        species.add(evolvesToDTO.getSpecies());
        species = getEvolves(evolvesToDTO.getEvolvesTo(), species);
        List<Integer> ids = idList(species);
        return findByPokemonIdList(ids);
    }

    public List<ValueDataDTO> getEvolves(List<EvolvesToDTO> evolvesToDTOs, List<ValueDataDTO> species) {
        for (EvolvesToDTO evolvesToDTO : evolvesToDTOs) {
            species.add(evolvesToDTO.getSpecies());
            getEvolves(evolvesToDTO.getEvolvesTo(), species);
        }
        return species;
    }

    public List<ValueDataDTO> specieListToFind(com.mx.serti.pokeapi.dto.PokemonDTO pokemonDTO, List<ValueDataDTO> species) {
        int pokemonId = pokemonDTO.getId();
        return species.stream().filter(specie -> validateId(pokemonId, specie.getUrl())).toList();
    }

    public boolean validateId(int pokemonId, String path) {
        int id = idPokemon(path);
        return pokemonId != id;
    }

    public int idPokemon(String path) {
        String[] pathSplit = path.split("/");
        return Integer.valueOf(pathSplit[pathSplit.length-1]);
    }

    public List<Integer> idList(List<ValueDataDTO> species) {
        List<Integer> ids = new ArrayList<>();
        species.forEach(s -> ids.add(idPokemon(s.getUrl())));
        return ids;
    }

    public List<com.mx.serti.pokeapi.dto.PokemonDTO> findByPokemonIdList(List<Integer> ids) {
        List<com.mx.serti.pokeapi.dto.PokemonDTO> pokemons = new ArrayList<>();
        for (Integer id : ids) {
            com.mx.serti.pokeapi.dto.PokemonDTO pokemon = findPokmeonByPokemonId((long) id);
            pokemons.add(pokemon);
        }
        return pokemons;
    }

    public List<PokemonDTO> saveListPokemon(List<PokemonDTO> pokemonDTOList) {
        return (List<PokemonDTO>) genericPokeApiLocalWebClient.saveList(pokemonDTOList);
    }

    public PokemonDTO pokemonApiToPokemonLocal(com.mx.serti.pokeapi.dto.PokemonDTO pokemonDTO) {
        return new PokemonDTO(pokemonDTO);
    }
}
