package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MagiaRepository extends JpaRepository<Magia, String> {

	@Query(value = "select * from magia where upper(nome) = upper(:nome)", nativeQuery = true)
	Magia buscarMagiaPorNome(String nome);
	
	@Query(value = "select descricao from magia_descricao where magia_id = :id", nativeQuery = true)
	List<String> buscarMagiaDescricao(String id);
	
}
