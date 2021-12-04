package br.lucas.lemmy.magia;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.lucas.lemmy.base.BaseCrudService;

@Service
@Transactional
public class MagiaService extends BaseCrudService<Magia, MagiaRepository> {

	@Autowired
	private MagiaRepository repo;

	public Magia buscarMagiaPorNome(String nome) {
		
		Magia magia = repo.buscarMagiaPeloNome(nome).get(0);
		magia.setDescricao(repo.buscarMagiaDescricaoPeloId(magia.getId()));
		magia.setComponentes(repo.buscarMagiaComponentesPeloId(magia.getId()));
		magia.setNiveisAcima(repo.buscarMagiaNiveisAcimaPeloId(magia.getId()));
		magia.setClasses(repo.buscarMagiaClassesPeloId(magia.getId()));
		
		return magia;
		
	}

}
