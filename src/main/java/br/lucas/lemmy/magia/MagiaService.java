package br.lucas.lemmy.magia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.lucas.lemmy.exception.BadRequestException;
import br.lucas.lemmy.exception.NotFoundException;

@Service
@Transactional
public class MagiaService {

	@Autowired
	public MagiaRepository repo;
		
	public List<Magia> getAll() {
		return repo.findAll();
	}
	public Magia getPeloId(String id) {
		if(!repo.existsById(id))
			throw new NotFoundException("ID não existente no banco de dados");
		return repo.findById(id).get();
	}
	public Magia getPeloNome(String nome) {
		List<Magia> magias = repo.findAll();
		for (Magia magia : magias) {
			if(magia.getNome().toLowerCase().equals(nome.toLowerCase())) {
				return magia;
			}
		}
		return null;
	}
	
	
	public ResponseEntity<String> post(Magia nova) {
		repo.save(nova);
		return ResponseEntity.status(HttpStatus.CREATED).body(nova.getId());
	}
	public ResponseEntity<List<Magia>> postMany(List<Magia> novas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repo.saveAllAndFlush(novas));
	}
	
	
	public String put(Magia modificada, String id) {
		if(!repo.existsById(id))
			throw new NotFoundException("ID não existente no banco de dados");
		if(!modificada.getId().equals(id))
			throw new BadRequestException("Para realizar o PUT os IDs do path e do body devem ser iguais");
		modificada = repo.save(modificada);
		return modificada.getId();
	}
	
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
