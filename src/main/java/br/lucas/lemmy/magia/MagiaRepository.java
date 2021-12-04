package br.lucas.lemmy.magia;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MagiaRepository extends JpaRepository<Magia, String> {

	@Query(value = "select * from magia where upper(nome) like upper(:nome || '%')", nativeQuery = true)
	List<Magia> buscarMagiaPeloNome(String nome);
	
	@Query(value = "select descricao from magia_descricao where magia_id = :id", nativeQuery = true)
	List<String> buscarMagiaDescricaoPeloId(String id);
	
	@Query(value = "select componentes from magia_componentes where magia_id = :id", nativeQuery = true)
	List<String> buscarMagiaComponentesPeloId(String id);
	
	@Query(value = "select niveis_acima from magia_niveis_acima where magia_id = :id", nativeQuery = true)
	List<String> buscarMagiaNiveisAcimaPeloId(String id);
	
	@Query(value = "select classes from magia_classes where magia_id = :id", nativeQuery = true)
	List<Classe> buscarMagiaClassesPeloId(String id);
	
}
