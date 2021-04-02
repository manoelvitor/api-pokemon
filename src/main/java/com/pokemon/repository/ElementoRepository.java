package com.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pokemon.model.Elemento;

@Repository
public interface ElementoRepository extends JpaRepository<Elemento, Long> {

}
