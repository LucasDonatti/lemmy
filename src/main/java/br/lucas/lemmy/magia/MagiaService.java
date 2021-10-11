package br.lucas.lemmy.magia;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MagiaService {
	
	@Autowired
	private MagiaRepository repo;
	
	
	public List<Magia> getAll() {
		return repo.findAll();
	}
	public Magia get(String id) {
		return repo.findById(id).get();
	}
	
	
	public String post(Magia nova) {
		repo.save(nova);
		return nova.getId();
	}
	
	
	public String put(Magia modificada, String id) {
		modificada = repo.save(modificada);
		return modificada.getId();
	}
	
	
	public void delete(String id) {
		repo.deleteById(id);
	}
	
}
