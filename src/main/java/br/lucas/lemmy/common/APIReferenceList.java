package br.lucas.lemmy.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class APIReferenceList {
	private int count;
	private List<APIReference> results;
	
	public APIReferenceList() {
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public List<APIReference> getResults() {
		return results;
	}
	
	public void setResults(List<APIReference> results) {
		this.results = results;
	}
	
}
