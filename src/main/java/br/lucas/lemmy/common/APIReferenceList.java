package br.lucas.lemmy.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class APIReferenceList {
	private Integer count;
	private List<APIReference> results;
	
	public APIReferenceList() {
	}
	
	public Integer getCount() {
		return count;
	}
	
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public List<APIReference> getResults() {
		return results;
	}
	
	public void setResults(List<APIReference> results) {
		this.results = results;
	}
	
}
