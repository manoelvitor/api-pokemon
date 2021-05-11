package com.pokemon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "tb_pokemon")
@Entity
public class Pokemon extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "nm_nome", length = 80)
	private String nome;

	private String imagem;
	
	private String descricao;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ManyToOne
	Elemento elemento;

	@ManyToOne
	Elemento subElemento;
	
	@ManyToOne
	Elemento fracoContra;
	


	public Elemento getSubElemento() {
		return subElemento;
	}

	public void setSubElemento(Elemento subElemento) {
		this.subElemento = subElemento;
	}

	public Elemento getElemento() {
		return elemento;
	}

	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
