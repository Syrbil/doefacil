package br.unisul.doacoes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.doacoes.domain.Notificacao;

@Repository
public interface NotificacaoRepository extends JpaRepository<Notificacao, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Notificacao obj WHERE obj.notificado.id = :notificadoId")
	public List<Notificacao> findNotificacoes(@Param("notificadoId") Integer notificado_id);
	
	
	

}