package br.lucas.lemmy;

import org.springframework.stereotype.Component;

@Component
public class Bot {
	private String prefixo = "!lm";
	private int prefixoTam = prefixo.length();
	
	public Bot() {
	}
	
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}
	public int getPrefixoTam() {
		return prefixoTam;
	}
	public void setPrefixoTam(int prefixoTam) {
		this.prefixoTam = prefixoTam;
	}
	
}
