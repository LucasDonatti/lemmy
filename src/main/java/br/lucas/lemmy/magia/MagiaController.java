package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.common.APIReferenceList;

@RestController
@RequestMapping("/api/magias")	
public class MagiaController {

	@Autowired
	private MagiaService service;
	
	@GetMapping
	public APIReferenceList getAll() throws Exception {
		return service.getAll();
	}
	
	@GetMapping("/indice={indice}")
	public Magia getMagiaPeloIndice(@PathVariable("indice") String indice) throws Exception {
		return service.getMagiaPeloIndice(indice);
	}
	
	@GetMapping("/nome={nome}")
	public APIReferenceList getMagiasPeloNome(@PathVariable("nome") String nome) throws Exception {
		return service.getMagiasPeloNome(nome);
	}
	
	@GetMapping("/nivel={nivel}")
	public APIReferenceList getMagiasPeloNivel(@PathVariable("nivel") String nivel) throws Exception {
		return service.getMagiasPeloNivel(nivel);
	}
	
}
