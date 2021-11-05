package br.lucas.lemmy.escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.common.APIReferenceList;

@RestController
@RequestMapping("/api/escolas")
public class EscolaController {

	@Autowired
	private EscolaService service;
	
	@GetMapping("/indice={indice}")
	public Escola getPeloIndiceAPIExterna(@PathVariable("indice") String indice) throws Exception {
		return service.obterPeloIndiceAPIExterna(indice);
	}
	
	@GetMapping("/nome={nome}")
	public APIReferenceList getPeloNomeAPIExterna(@PathVariable("nome") String nome) throws Exception {
		return service.obterPeloNomeAPIExterna(nome);
	}
	
}
