package br.lucas.lemmy.common;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class APIReferenceList {
	@Id
	private String id;
	private Integer count;
	@OneToMany
	@JoinColumn(name="apireference_list_id")
	private List<APIReference> results;
	
	public APIReferenceList() {
		this.id = UUID.randomUUID().toString();
	}
	
	public APIReferenceList(String id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		APIReferenceList other = (APIReferenceList) obj;
		return Objects.equals(id, other.id);
	}
	
}
