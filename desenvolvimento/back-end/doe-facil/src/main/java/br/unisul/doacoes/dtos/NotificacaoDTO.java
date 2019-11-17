package br.unisul.doacoes.dtos;

import java.io.Serializable;


import br.unisul.doacoes.domain.Notificacao;
import br.unisul.doacoes.domain.Usuario;


public class NotificacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String conteudo;
	private boolean lida;
	private Usuario notificador;
	private Usuario notificado;
	


	public NotificacaoDTO() {
	}

	public NotificacaoDTO(Notificacao obj) {
		
		this.id = obj.getId();
		this.conteudo = obj.getConteudo();
		this.lida = obj.isLida();
		this.notificador = obj.getNotificador();
		this.notificado=obj.getNotificado();
		
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public boolean isLida() {
		return lida;
	}

	public void setLida(boolean lida) {
		this.lida = lida;
	}

	public Usuario getNotificador() {
		return notificador;
	}

	public void setNotificador(Usuario notificador) {
		this.notificador = notificador;
	}

	public Usuario getNotificado() {
		return notificado;
	}

	public void setNotificado(Usuario notificado) {
		this.notificado = notificado;
	}

	
	
}


