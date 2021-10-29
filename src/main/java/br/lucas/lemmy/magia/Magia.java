package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Magia {
	private String index;
	private String name;
	private List<String> desc;
	private List<String> higher_level;
	private String range;
	private List<String> components;
	private String material;
	private Boolean ritual;
	private String duration;
	private Boolean concentration;
	private String casting_time;
	private Integer level;
	
	public Magia() {
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

	public Boolean getRitual() {
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

	public Boolean getConcentration() {
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
	
}
