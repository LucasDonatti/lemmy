package br.lucas.lemmy.magia;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import br.lucas.lemmy.common.APIReference;

@Component
@Entity
public class Magia {
	@Id
	private String id;
	private String index;
	private String name;
	@Column(name="description", columnDefinition = "text")
	@ElementCollection(targetClass=String.class)
	private List<String> desc;
	@Column(columnDefinition = "text")
	@ElementCollection(targetClass=String.class)
	private List<String> higher_level;
	private String range;
	@ElementCollection(targetClass=String.class)
	private List<String> components;
	private String material;
	private Boolean ritual;
	private String duration;
	private Boolean concentration;
	private String casting_time;
	private Integer level;
	@ManyToOne
	@JoinColumn(name="school_id")
	private APIReference school;
	
	public Magia() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Magia(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getDesc() {
		return desc;
	}

	public void setDesc(List<String> desc) {
		this.desc = desc;
	}
	
	public List<String> getHigher_level() {
		return higher_level;
	}
	
	public void setHigher_level(List<String> higher_level) {
		this.higher_level = higher_level;
	}
	
	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public List<String> getComponents() {
		return components;
	}

	public void setComponents(List<String> components) {
		this.components = components;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Boolean isConcentration() {
		return concentration;
	}

	public void setConcentration(Boolean concentration) {
		this.concentration = concentration;
	}

	public String getCasting_time() {
		return casting_time;
	}

	public void setCasting_time(String casting_time) {
		this.casting_time = casting_time;
	}

	public Integer getLevel() {
		return level;
	}
	
	public void setLevel(Integer level) {
		this.level = level;
	}
	
	public APIReference getSchool() {
		return school;
	}
	
	public void setSchool(APIReference school) {
		this.school = school;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Magia other = (Magia) obj;
		return Objects.equals(id, other.id);
	}
	
}
