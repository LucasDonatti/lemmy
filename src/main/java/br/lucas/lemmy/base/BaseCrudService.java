package br.lucas.lemmy.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.lucas.lemmy.base.exception.RegistroJaExistente;
import br.lucas.lemmy.base.exception.RegistroNaoExistente;

public class BaseCrudService<ENTITY extends BaseEntity, 
							 REPOSITORY extends JpaRepository<ENTITY, String>> {

	@Autowired
	private REPOSITORY repo;
	
	public List<ENTITY> obterTodos() {
		return repo.findAll();
	}

	public ENTITY obterPeloId(String id) {
		try {
			return repo.findById(id).get();
		} catch (Exception e) {
			throw new RegistroNaoExistente();
		}
	}

	public ENTITY criar(ENTITY nova) {
		if(repo.findById(nova.getId()).isPresent()) {
			throw new RegistroJaExistente();
		}
		return repo.save(nova);
	}

	public List<ENTITY> criarVarios(List<ENTITY> novas) {
		for(int i = 0; i < novas.size(); i++) {
			if(repo.findById(novas.get(i).getId()).isPresent()) {
				throw new RegistroJaExistente();
			}
		}
		return repo.saveAllAndFlush(novas);
	}

	public void atualizar(ENTITY modificada) {
		if(!repo.findById(modificada.getId()).isPresent()) {
			throw new RegistroNaoExistente();
		}
		repo.save(modificada);
	}

	public void excluirPeloId(String id) {
		try {
			repo.deleteById(id);
		} catch (Exception e) {
			throw new RegistroNaoExistente();
		}
	}

}
