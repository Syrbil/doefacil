package br.unisul.doacoes.dtos;

import java.io.Serializable;

import br.unisul.doacoes.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeUsuario;
	private String nomeCompleto;
	private String email;
	
	private String imgUsuario;
	
	private Integer votosPositivosUsuario;
	private Integer votosNegativosUsuario;
	
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;

	public UsuarioDTO() {
	}

	public UsuarioDTO(Usuario user) {
		id = user.getIdUsuario();
		nomeUsuario = user.getNomeUsuario();
		nomeCompleto = user.getNomeCompleto();
		email = user.getEmail();

		imgUsuario=user.getImgUsuario();
		
		votosPositivosUsuario = user.getVotosPositivosUsuario();
		votosNegativosUsuario = user.getVotosNegativosUsuario();
		
		estado=user.getEstado();
		cidade=user.getCidade();
		bairro=user.getBairro();
		rua=user.getRua();
		numero=user.getNumero();
		complemento=user.getComplemento();
		
	}


	

	public String getImgUsuario() {
		return imgUsuario;
	}

	public void setImgUsuario(String imgUsuario) {
		this.imgUsuario = imgUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Integer getVotosPositivosUsuario() {
		return votosPositivosUsuario;
	}

	public void setVotosPositivosUsuario(Integer votosPositivosUsuario) {
		this.votosPositivosUsuario = votosPositivosUsuario;
	}

	public Integer getVotosNegativosUsuario() {
		return votosNegativosUsuario;
	}

	public void setVotosNegativosUsuario(Integer votosNegativosUsuario) {
		this.votosNegativosUsuario = votosNegativosUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	
}