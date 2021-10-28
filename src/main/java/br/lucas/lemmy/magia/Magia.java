package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Magia {
	private String index;
	private String name;
	private List<String> desc;
	private List<String> higher_level;
	private int level;
	
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
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
}
