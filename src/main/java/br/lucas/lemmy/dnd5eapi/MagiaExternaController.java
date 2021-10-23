package br.lucas.lemmy.dnd5eapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("magias-externas")	
public class MagiaExternaController {

	@Autowired
	private MagiaExternaService service;
	
	@GetMapping("/{indice}")
	public MagiaExterna getMagiaExternaPeloIndice(@PathVariable("indice") String indice) throws Exception {
		return service.getMagiaExternaPeloIndice(indice);
	}
	
}
