  
package br.unisul.doacoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.doacoes.domain.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Integer> {

	//pegar todas as doaçoes DISPONÍVEIS
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.recebedor.id is null")
	public List<Doacao> findDisponiveis();
	
	//pegar todas as doaçoes feitas de um usuario
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.doador.id = :doadorId")
	public List<Doacao> findFeitas(@Param("doadorId") Integer doador_id);
	
	//pegar todas as doaçoes feitas e que estao disponívies de um usuario
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.doador.id = :doadorId AND obj.recebedor.id is null")
	public List<Doacao> findFeitasDisponiveis(@Param("doadorId") Integer doador_id);
	
	//pegar todas as doaçoes recebidas de um usuario
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.recebedor.id = :recebedorId")
	public List<Doacao> findRecebidas(@Param("recebedorId") Integer recebedor_id);
	
	//pegar todas as doaçoes de uma categoria
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Doacao obj WHERE obj.categoria = :categoria")
	public List<Doacao> findByCategoria(@Param("categoria") String cat);
	
	//pegar doacoes que contem o nome no filtro
	@Transactional(readOnly = true)
	@Query("select d from Doacao d where d.nome like %:nome%")
	public List<Doacao> findByDoacaoContaining(@Param("nome") String nome);
	
}