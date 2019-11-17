package br.unisul.doacoes.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class Notificacao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String conteudo;
	private boolean lida;
	
	@ManyToOne
	@JoinColumn(name = "notificador_id")
	private Usuario notificador;
	
	@ManyToOne
	@JoinColumn(name = "notificado_id")
	private Usuario notificado;

	public Notificacao() {}


	public Notificacao(Integer id, String conteudo, Usuario notificador, Usuario notificado) {
		super();
		this.id = id;
		this.conteudo = conteudo;
		this.notificador = notificador;
		this.notificado=notificado;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	

}
