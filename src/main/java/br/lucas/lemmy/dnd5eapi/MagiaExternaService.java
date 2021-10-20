package br.lucas.lemmy.dnd5eapi;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MagiaExternaService {
	
	RestTemplate restTemplate = new RestTemplate();
	MagiaExterna magia = restTemplate.getForObject("https://www.dnd5eapi.co/api/spells/magic-missile", MagiaExterna.class);
	
	public MagiaExterna get() {
		System.out.println(magia.getName());
		return magia;
	}
	
}
