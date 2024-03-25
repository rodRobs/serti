package com.mx.serti.chainevolutions.repository;

import com.mx.serti.chainevolutions.entity.ChainEvolution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChainEvolutionRepository extends JpaRepository<ChainEvolution, Long> {

    ChainEvolution findByPokemonsPokeId(Long pokeId);

}
