package br.lucas.lemmy.escola;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.lucas.lemmy.common.APIReferenceList;

@Service
public class EscolaService {

	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	RestTemplate restTemplate = new RestTemplate();
	String url = "https://www.dnd5eapi.co/api/magic-schools/";
	
	public APIReferenceList getAll() throws Exception {
		String retorno = restTemplate.getForObject(url, String.class);
		APIReferenceList escolas = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return escolas;
	}

	public Escola getEscolaPeloIndice(String indice) throws Exception {
		String retorno = restTemplate.getForObject(url + indice, String.class);
		Escola escola = jacksonObjectMapper.readValue(retorno, Escola.class);
		return escola;
	}

	public APIReferenceList getEscolaPeloNome(String nome) throws Exception {
		String retorno = restTemplate.getForObject(url + "?name=" + nome, String.class);
		APIReferenceList escolas = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		return escolas;
	}
	
}
