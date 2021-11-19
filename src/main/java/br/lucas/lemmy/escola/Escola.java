package br.lucas.lemmy.escola;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import br.lucas.lemmy.base.BaseEntity;

@Entity
public class Escola extends BaseEntity {
	
	private String indice;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(columnDefinition = "text", nullable = false)
	@ElementCollection(targetClass = String.class)
	private List<String> descricao;
	
	public String getIndice() {
		return indice;
	}
	
	public void setIndice(String indice) {
		this.indice = indice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
		this.indice = nome.toLowerCase().replace(" ", "-");
	}

	public List<String> getDescricao() {
		return descricao;
	}

	public void setDescricao(List<String> descricao) {
		this.descricao = descricao;
	}
	
}
