package br.lucas.lemmy.dnd5eapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("magia-externa")
public class MagiaExternaController {

	@Autowired
	private MagiaExternaService service;
	
	@GetMapping
	public MagiaExterna getMagiaExterna() throws Exception {
		return service.getMagiaExterna();
	}
	
	@GetMapping("indice")
	public String getIndice() throws Exception {
		return service.getIndice();
	}
	
	@GetMapping("nome")
	public String getNome() throws Exception {
		return service.getNome();
	}
	
	@GetMapping("descricao")
	public List<JsonNode> getDescricao() throws Exception {
		return service.getDescricao();
	}
	
	@GetMapping("nivel-acima")
	public List<JsonNode> getNivelAcima() throws Exception {
		return service.getNivelAcima();
	}
	
	@GetMapping("nivel")
	public int getNivel() throws Exception {
		return service.getNivel();
	}
	
}
