package com.mx.serti.chainevolutions.service;

import com.mx.serti.chainevolutions.dto.ChainEvolutionDTO;

import java.util.List;

public interface ChainEvolutionService {

    List<ChainEvolutionDTO> findAll();

    ChainEvolutionDTO findByPokeId(Long pokeId);

    ChainEvolutionDTO findById(Long id);

    ChainEvolutionDTO save(ChainEvolutionDTO chainEvolutionDTO);

    ChainEvolutionDTO update(Long id, ChainEvolutionDTO chainEvolutionDTO);

    void deleteById(Long id);

}
