package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.model.Regiao;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {

}
