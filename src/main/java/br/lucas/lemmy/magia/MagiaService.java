package br.lucas.lemmy.magia;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;

@Service
@Transactional
public class MagiaService extends BaseCrudService<Magia, MagiaRepository> {

	@Autowired
	private MagiaRepository repository;

	public Magia buscarMagiaPorNome(String nome) {
		
		Magia magia = repository.buscarPeloNome(nome).get(0);
		magia.setDescricao(repository.buscarDescricaoPeloId(magia.getId()));
		magia.setComponentes(repository.buscarComponentesPeloId(magia.getId()));
		magia.setNiveisAcima(repository.buscarNiveisAcimaPeloId(magia.getId()));
		magia.setClasses(repository.buscarClassesPeloId(magia.getId()));
		
		return magia;
		
	}

}
