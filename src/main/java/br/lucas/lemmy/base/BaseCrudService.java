package br.lucas.lemmy.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.lucas.lemmy.base.exception.RegistroJaExistente;
import br.lucas.lemmy.base.exception.RegistroNaoExistente;

public class BaseCrudService<ENTITY extends BaseEntity, 
							 REPOSITORY extends JpaRepository<ENTITY, String>> {

	@Autowired
	private REPOSITORY repository;
	
	public List<ENTITY> obterTodos() {
		return repository.findAll();
	}

	public ENTITY obterPeloId(String id) {
		try {
			return repository.findById(id).get();
		} catch (Exception e) {
			throw new RegistroNaoExistente();
		}
	}

	public ENTITY criar(ENTITY nova) {
		if(repository.findById(nova.getId()).isPresent()) {
			throw new RegistroJaExistente();
		}
		return repository.save(nova);
	}

	public List<ENTITY> criarVarios(List<ENTITY> novas) {
		for(int i = 0; i < novas.size(); i++) {
			if(repository.findById(novas.get(i).getId()).isPresent()) {
				throw new RegistroJaExistente();
			}
		}
		return repository.saveAllAndFlush(novas);
	}

	public void atualizar(ENTITY modificada) {
		if(!repository.findById(modificada.getId()).isPresent()) {
			throw new RegistroNaoExistente();
		}
		repository.save(modificada);
	}

	public void excluirPeloId(String id) {
		try {
			repository.deleteById(id);
		} catch (Exception e) {
			throw new RegistroNaoExistente();
		}
	}

}
