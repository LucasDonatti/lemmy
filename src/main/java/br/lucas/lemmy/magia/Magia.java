package br.lucas.lemmy.magia;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.lucas.lemmy.base.BaseEntity;
import br.lucas.lemmy.magia.classe.Classe;
import br.lucas.lemmy.magia.escola.Escola;

@Entity
public class Magia extends BaseEntity {
	
	private String indice;
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	@Column(columnDefinition = "text", nullable = false)
	@ElementCollection(targetClass = String.class)
	private List<String> descricao;
	
	@Column(columnDefinition = "text")
	@ElementCollection(targetClass = String.class)
	private List<String> niveisAcima;
	
	@Column(nullable = false)
	private String alcance;
	
	@Column(nullable = false)
	@ElementCollection(targetClass = String.class)
	private List<String> componentes;
	
	private String material;
	
	@Column(nullable = false)
	private Boolean ritual;
	
	@Column(nullable = false)
	private String duracao;
	
	@Column(nullable = false)
	private Boolean concentracao;
	
	@Column(nullable = false)
	private String tempoDeConjuracao;
	
	@Column(nullable = false)
	private Integer nivel;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private Escola escola;
	
	@Column(name = "classe", nullable = false)
	@Enumerated(EnumType.STRING)
	@ElementCollection(targetClass = Classe.class)
	private List<Classe> classes;
	
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

	public List<String> getNiveisAcima() {
		return niveisAcima;
	}

	public void setNiveisAcima(List<String> niveisAcima) {
		this.niveisAcima = niveisAcima;
	}

	public String getAlcance() {
		return alcance;
	}

	public void setAlcance(String alcance) {
		this.alcance = alcance;
	}

	public List<String> getComponentes() {
		return componentes;
	}

	public void setComponentes(List<String> componentes) {
		this.componentes = componentes;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Boolean isRitual() {
		return ritual;
	}

	public void setRitual(Boolean ritual) {
		this.ritual = ritual;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Boolean isConcentracao() {
		return concentracao;
	}

	public void setConcentracao(Boolean concentracao) {
		this.concentracao = concentracao;
	}

	public String getTempoDeConjuracao() {
		return tempoDeConjuracao;
	}

	public void setTempoDeConjuracao(String tempoDeConjuracao) {
		this.tempoDeConjuracao = tempoDeConjuracao;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}
	
	public Escola getEscola() {
		return escola;
	}
	
	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	public List<Classe> getClasses() {
		return classes;
	}
	
	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}
	
}
