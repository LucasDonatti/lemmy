package br.lucas.lemmy.dnd5eapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.lucas.lemmy.common.APIReferenceList;

@Service
public class MagiaExternaService {
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	RestTemplate restTemplate = new RestTemplate();
	String url = "https://www.dnd5eapi.co/api/spells/";
	
	public MagiaExterna getMagiaExternaPeloIndice(String indice) throws Exception {
		String retorno = restTemplate.getForObject("https://www.dnd5eapi.co/api/spells/" + indice, String.class);
		MagiaExterna magia = jacksonObjectMapper.readValue(retorno, MagiaExterna.class);
		return magia;
	}
	
	public APIReferenceList getMagiaExternaPeloNome(String nome) throws Exception {
		String retorno = restTemplate.getForObject(url + "?name=" + nome, String.class);
		APIReferenceList result = jacksonObjectMapper.readValue(retorno, APIReferenceList.class);
		System.out.println(result.getResults());
		return result;
	}
	
//	public MagiaExterna getMagiaExternaPeloNome(String nome) throws Exception {
//		nome = nome.toLowerCase().replace(" ", "-");
//		String retorno = restTemplate.getForObject("https://www.dnd5eapi.co/api/spells/" + nome, String.class);
//		MagiaExterna magia = jacksonObjectMapper.readValue(retorno, MagiaExterna.class);
//		return magia;
//	}
	
}















