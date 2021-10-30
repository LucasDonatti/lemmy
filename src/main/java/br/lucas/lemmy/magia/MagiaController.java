package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/magias")	
public class MagiaController {

	@Autowired
	private MagiaService service;
	
	@GetMapping("/indice={indice}")
	public Magia getMagiaPeloIndice(@PathVariable("indice") String indice) throws Exception {
		return service.getMagiaPeloIndice(indice);
	}
	
}
