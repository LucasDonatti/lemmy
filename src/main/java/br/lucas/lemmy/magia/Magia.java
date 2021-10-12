package br.lucas.lemmy.magia;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Magia {
	@Id
	private String id;
	private String nome;
	private String descricao;
	private String niveisAcima;
	private String alcance;
	private String componentes;
	private String material;
	private boolean ritual;
	private String duracao;
	private boolean concentracao;
	private String tempoConjuracao;
	private int nivel;
	
	// CONSTRUTORES
	public Magia() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Magia(String id) {
		this.id = id;
	}
	
	// GETTERS E SETTERS
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNiveisAcima() {
		return niveisAcima;
	}

	public void setNiveisAcima(String niveisAcima) {
		this.niveisAcima = niveisAcima;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public String getComponentes() {
		return componentes;
	}

	public void setComponentes(String componentes) {
		this.componentes = componentes;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public boolean isRitual() {
		return ritual;
	}

	public void setRitual(boolean ritual) {
		this.ritual = ritual;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public boolean isConcentracao() {
		return concentracao;
	}

	public void setConcentracao(boolean concentracao) {
		this.concentracao = concentracao;
	}

	public String getTempoConjuracao() {
		return tempoConjuracao;
	}

	public void setTempoConjuracao(String tempoConjuracao) {
		this.tempoConjuracao = tempoConjuracao;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
