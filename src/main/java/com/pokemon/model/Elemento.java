package com.pokemon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_elemento")
public class Elemento extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	private String nomeElemento;

	public String getNomeElemento() {
		return nomeElemento;
	}

	public void setNomeElemento(String nomeElemento) {
		this.nomeElemento = nomeElemento;
	}

	public Elemento() {

	}

}
