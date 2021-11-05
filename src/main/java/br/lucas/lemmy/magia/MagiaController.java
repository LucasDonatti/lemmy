package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.lemmy.common.APIReferenceList;

@RestController
@RequestMapping("/api/magias")	
public class MagiaController {

	@Autowired
	private MagiaService service;
	
	@GetMapping("/indice={indice}")
	public Magia getPeloIndiceAPIExterna(@PathVariable("indice") String indice) throws Exception {
		return service.obterPeloIndiceAPIExterna(indice);
	}
	
	@GetMapping("/nome={nome}")
	public APIReferenceList getPeloNomeAPIExterna(@PathVariable("nome") String nome) throws Exception {
		return service.obterPeloNomeAPIExterna(nome);
	}
	
	@GetMapping
	public List<Magia> getAll() {
		return service.obterTodas();
	}
	
	@GetMapping("/{id}")
	public Magia getById(@PathVariable String id) {
		return service.obterPeloId(id);
	}
	
	@PostMapping
	public String post(@RequestBody Magia nova) {
		nova = service.criar(nova);
		return nova.getId();
	}
	
}
