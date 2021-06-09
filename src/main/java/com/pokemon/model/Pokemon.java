package com.pokemon.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
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
	private Elemento elemento;

	@ManyToOne
	private Elemento subElemento;
	
	@ManyToOne
	private Regiao regiao;
	
	
	
	public Regiao getRegiao() {
		return regiao;
	}

	public void setRegiao(Regiao regiao) {
		this.regiao = regiao;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Elemento> fracoContra;
	
	
	
	public List<Elemento> getFracoContra() {
		return fracoContra;
	}

	public void setFracoContra(List<Elemento> fracoContra) {
		this.fracoContra = fracoContra;
	}

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
