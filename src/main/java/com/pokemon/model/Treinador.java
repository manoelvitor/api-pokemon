package com.pokemon.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_treinador")
public class Treinador extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String nome;
	private Integer idade;
	private Integer qntPokemon;

	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Pokemon> pokemons;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Integer getQntPokemon() {
		return qntPokemon;
	}
	public void setQntPokemon(Integer qntPokemon) {
		this.qntPokemon = qntPokemon;
	}
	public Treinador() {

	}
	
	public List<Pokemon> getPokemons() {
		return pokemons;
	}
	
	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	
}
