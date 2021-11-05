package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.lucas.lemmy.common.APIReferenceList;

@Service
public class MagiaService {
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	@Autowired 
	private MagiaRepository repo;
	
	RestTemplate restTemplate = new RestTemplate();
	String url = "https://www.dnd5eapi.co/api/spells/";
	
	// P E L O   I N D I C E
	public Magia obterPeloIndiceAPIExterna(String indice) throws Exception {
		try {
			String retorno = restTemplate.getForObject(url + indice, String.class);
			Magia magia = jacksonObjectMapper.readValue(retorno, Magia.class);
			return magia;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	// P E L O   N O M E
	public APIReferenceList obterPeloNomeAPIExterna(String nome) throws Exception {
		String retorno = restTemplate.getForObject(url + "?name=" + nome, String.class);
		APIReferenceList magias = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return magias;
	}
	
	public List<Magia> obterTodas() {
		return repo.findAll();
	}
	
	public Magia obterPeloId(String id) {
		return repo.findById(id).get();
	}
	
	public Magia criar(Magia nova) {
		return repo.save(nova);
	}
	
}















