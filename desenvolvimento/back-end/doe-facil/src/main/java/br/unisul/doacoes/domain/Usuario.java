package br.unisul.doacoes.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUsuario;
	private String nomeCompleto;
	private String nomeUsuario;
	private String email;
	private String senha;
	private String dataNasc;
	private String cpf;
	
    private String imgUsuario;
	
	private Integer votosPositivosUsuario=0;
	private Integer votosNegativosUsuario=0;
	
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	

	@JsonIgnore
	@OneToMany(mappedBy="notificado")
	private List<Notificacao> notificacoes = new ArrayList<>();


	@JsonIgnore 
	@OneToMany(mappedBy = "doador") 
	private List<Doacao> feitas = new ArrayList<>();
	 

	
	@JsonIgnore
	@OneToMany(mappedBy = "recebedor") 
	private List<Doacao> recebidas = new ArrayList<>();
	 

	public Usuario() {
		
	}
	
	public Usuario(Integer idUsuario, String nomeCompleto, String nomeUsuario, String email, String senha,
			String dataNasc, String estado, String cidade, String bairro, String rua, String numero,
			String complemento) {
		super();
		this.idUsuario = idUsuario;
		this.nomeCompleto = nomeCompleto;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.senha = senha;
		this.dataNasc = dataNasc;
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.complemento = complemento;
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


	public List<Notificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<Notificacao> notificacoes) {
	this.notificacoes = notificacoes;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getImgUsuario() {
		return imgUsuario;
	}

	public void setImgUsuario(String imgUsuario) {
		this.imgUsuario = imgUsuario;
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

	public List<Doacao> getFeitas() {
		return feitas;
	}

	public void setFeitas(List<Doacao> feitas) {
		this.feitas = feitas;
	}

	public List<Doacao> getRecebidas() {
		return recebidas;
	}

	public void setRecebidas(List<Doacao> recebidas) {
		this.recebidas = recebidas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

}