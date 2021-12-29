package br.lucas.lemmy;

import org.springframework.stereotype.Component;

@Component
public class Bot {
	private String prefixo = "!lm";
	private Integer tamanhoDoPrefixo = prefixo.length();
	
	public Bot() {
	}
	
	public String getPrefixo() {
		return prefixo;
	}
	public void setPrefixo(String prefixo) {
		this.prefixo = prefixo;
	}
	public Integer getTamanhoDoPrefixo() {
		return tamanhoDoPrefixo;
	}
	public void setTamanhoDoPrefixo(Integer tamanhoDoPrefixo) {
		this.tamanhoDoPrefixo = tamanhoDoPrefixo;
	}
	
}
