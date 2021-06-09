package com.pokemon.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "tb_regiao")
public class Regiao extends AbstractEntity{

	private static final long serialVersionUID = 1L;
	
	private String nomeRegiao;

	public String getNomeRegiao() {
		return nomeRegiao;
	}

	public void setNomeRegiao(String nomeRegiao) {
		this.nomeRegiao = nomeRegiao;
	}

	public Regiao() {
	
	}
	
	
	
	

}
