package br.lucas.lemmy.magia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.lucas.lemmy.common.APIReferenceList;

@Service
public class MagiaService {
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	RestTemplate restTemplate = new RestTemplate();
	String url = "https://www.dnd5eapi.co/api/spells/";
	
	// A L L
	public APIReferenceList getAll() throws Exception {
		String retorno = restTemplate.getForObject(url, String.class);
		APIReferenceList magias = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return magias;
	}
	
	// P E L O   I N D I C E
	public Magia getMagiaPeloIndice(String indice) throws Exception {
		String retorno = restTemplate.getForObject(url + indice, String.class);
		Magia magia = jacksonObjectMapper.readValue(retorno, Magia.class);
		return magia;
	}
	
	// P E L O   N O M E
	public APIReferenceList getMagiasPeloNome(String nome) throws Exception {
		String retorno = restTemplate.getForObject(url + "?name=" + nome, String.class);
		APIReferenceList magias = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return magias;
	}
	
	public APIReferenceList getMagiasPeloNivel(String nivel) throws Exception {
		String retorno = restTemplate.getForObject(url + "?level=" + nivel, String.class);
		APIReferenceList magias = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return magias;
	}
	
}















