package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.model.Treinador;

@Repository
public interface TreinadorRepository extends JpaRepository<Treinador, Long> {

}
