package br.lucas.lemmy.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.lucas.lemmy.base.exception.RequisicaoPutInvalida;

public class BaseCrudController<ENTITY extends BaseEntity, 
								REPOSITORY extends JpaRepository<ENTITY, String>, 
								SERVICE extends BaseCrudService<ENTITY, REPOSITORY>> {
	
	@Autowired
	private SERVICE service;
	
	@GetMapping
	public List<ENTITY> getAll() {
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public ENTITY getById(@PathVariable("id") String id) {
		return service.obterPeloId(id);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String post(@RequestBody ENTITY nova) {
		nova = service.criar(nova);
		return nova.getId();
	}
	
	@PostMapping("/post-many")
	@ResponseStatus(value = HttpStatus.CREATED)
	public List<ENTITY> postMany(@RequestBody List<ENTITY> novas) {
		novas = service.criarVarios(novas);
		return novas;
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") String id, @RequestBody ENTITY modificada) {
		if(!id.equals(modificada.getId())) {
			throw new RequisicaoPutInvalida();
		}
		service.atualizar(modificada);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") String id) {
		service.excluirPeloId(id);
	}
	
}
