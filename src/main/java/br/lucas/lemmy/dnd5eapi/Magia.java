package br.lucas.lemmy.dnd5eapi;

import java.util.List;

public class Magia {
	private String index;
	private String name;
	private List<String> desc;
	
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
	
}
