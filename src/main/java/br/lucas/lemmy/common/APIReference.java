package br.lucas.lemmy.common;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class APIReference {
	@Id
	private String id;
	private String index;
	private String name;
	private String url;
	
	public APIReference() {
		this.id = UUID.randomUUID().toString();
	}
	
	public APIReference(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getIndex() {
		return index;
	}
	
	public void setIndex(String index) {
		this.index = index;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
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
		APIReference other = (APIReference) obj;
		return Objects.equals(id, other.id);
	}
	
}
