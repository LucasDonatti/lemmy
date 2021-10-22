package br.lucas.lemmy.dnd5eapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MagiaExternaService {
	
	@Autowired
	private ObjectMapper jacksonObjectMapper;
	
	RestTemplate restTemplate = new RestTemplate();
	String retorno = restTemplate.getForObject("https://www.dnd5eapi.co/api/spells/wish", String.class);
	
	public MagiaExterna getMagiaExterna() throws Exception {
		MagiaExterna magia = jacksonObjectMapper.readValue(retorno, MagiaExterna.class);
		return magia;
	}
	
	public String getIndice() throws Exception {
		JsonNode jsonNode = jacksonObjectMapper.readTree(retorno);
		String indice = jsonNode.get("index").asText();
		return indice;
	}
	
	public String getNome() throws Exception {
		JsonNode jsonNode = jacksonObjectMapper.readTree(retorno);
		String nome = jsonNode.get("name").asText();
		return nome;
	}
	
	public List<JsonNode> getDescricao() throws Exception {
		JsonNode jsonNode = jacksonObjectMapper.readTree(retorno);
		List<JsonNode> descricao = jsonNode.findValues("desc");
		return descricao;
	}

	public List<JsonNode> getNivelAcima() throws Exception {
		JsonNode jsonNode = jacksonObjectMapper.readTree(retorno);
		List<JsonNode> nivelAcima = jsonNode.findValues("higher_level");
		return nivelAcima;
	}
	
	public int getNivel() throws Exception {
		JsonNode jsonNode = jacksonObjectMapper.readTree(retorno);
		int nivel = jsonNode.get("level").asInt();
		return nivel;
	}
	
}















