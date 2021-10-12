package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/magias")
public class MagiaController {
	
	@Autowired
	private MagiaService service;
	
	
	@GetMapping
	public List<Magia> getAll() {
		return service.getAll();
	}
	@GetMapping("{id}")
	public Magia get(@PathVariable("id") String id) {
		return service.get(id);
	}
	
	
	@PostMapping
	public String post(@RequestBody Magia nova) {
		return service.post(nova);
	}
	@PostMapping("/post-many")
	public List<Magia> postMany(@RequestBody List<Magia> novas) {
		return service.postMany(novas);
	}
	
	
	@PutMapping("{id}")
	public String put(@RequestBody Magia modificada, @PathVariable("id") String id) {
		return service.put(modificada, id);
	}
	
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		service.delete(id);
	}
	
	
}
