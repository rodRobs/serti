package com.mx.serti.chainevolutions.entity;

import com.mx.serti.chainevolutions.dto.ChainEvolutionDTO;
import com.mx.serti.pokemons.dto.PokemonDTO;
import com.mx.serti.pokemons.entity.Pokemon;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tbl_chain_evolution")
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ChainEvolution implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chev_id")
    private Long chevId;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "poke_id")
    private List<Pokemon> pokemons;

    @Column(name = "evo_min_level")
    private int evoMinLevel;

    @Column(name = "chev_envolve")
    private int chevEnvolve;

    public ChainEvolution(ChainEvolutionDTO chainEvolution) {
        this.setChevId(chainEvolution.getChevId());
        this.setPokemons(chainEvolution.getPokemons().stream().map(Pokemon::new).toList());
        this.setEvoMinLevel(chainEvolution.getEvoMinLevel());
        this.setChevEnvolve(chainEvolution.getChevEnvolve());
    }
}
