package br.lucas.lemmy.magia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MagiaRepository extends JpaRepository<Magia, String> {

	@Query(value =  "select * from magia where upper(nome) = upper(:nome)", nativeQuery = true)
	Magia buscarMagiaPorNome(String nome);
	
}
