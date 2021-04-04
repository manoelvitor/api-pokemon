package com.pokemon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pokemon.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {

	//Query para pegar todos pokemons via nome do elemento
	@Query("select p from Pokemon p where p.elemento.nomeElemento =?1")
	List<Pokemon> listarPorNomeElemento(String nomeElemento);

}
