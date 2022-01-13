package br.lucas.lemmy.bot;

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

	public Integer getTamanhoDoPrefixo() {
		return tamanhoDoPrefixo;
	}

}
