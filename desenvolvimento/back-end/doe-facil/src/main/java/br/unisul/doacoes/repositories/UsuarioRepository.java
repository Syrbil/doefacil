package br.unisul.doacoes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.unisul.doacoes.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	@Transactional(readOnly=true)
	@Query("SELECT obj FROM Usuario obj WHERE obj.nomeUsuario = :nomeUsuario and obj.senha = :senha ")
	public Usuario login(@Param("nomeUsuario") String nomeUsuario ,@Param("senha") String senha);
		
}