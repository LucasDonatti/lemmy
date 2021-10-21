package br.lucas.lemmy.dnd5eapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MagiaExternaService {
	
	RestTemplate restTemplate = new RestTemplate();
	String magias = restTemplate.getForObject("https://www.dnd5eapi.co/api/spells", String.class);
	
	public String get() {
		return magias;
	}
	
}
