package br.unisul.doacoes.dtos;

import java.io.Serializable;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.domain.Usuario;

public class DoacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String categoria;
	private String img;
	private String status;
	private String metodoFrete;
	private String descricao;
	private Integer votosPositivos;
	private Integer votosNegativos;
	private String dataInicio;
	private String dataFim;
	private Usuario doador;
	
	

	public DoacaoDTO() {
		
	}

	public DoacaoDTO(Doacao obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.categoria=obj.getCategoria();
		this.img = obj.getImg();
		this.status = obj.getStatus();
		this.metodoFrete = obj.getMetodoFrete();
		this.descricao = obj.getDescricao();
		this.votosPositivos = obj.getVotosPositivos();
		this.votosNegativos = obj.getVotosNegativos();
		this.dataInicio = obj.getDataInicio();
		this.dataFim = obj.getDataFim();
		this.doador=obj.getDoador();
		
	}

	public Usuario getDoador() {
		return doador;
	}

	public void setDoador(Usuario doador) {
		this.doador = doador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMetodoFrete() {
		return metodoFrete;
	}

	public void setMetodoFrete(String metodoFrete) {
		this.metodoFrete = metodoFrete;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public void setVotosPositivos(int votosPositivos) {
		this.votosPositivos = votosPositivos;
	}


	public void setVotosNegativos(int votosNegativos) {
		this.votosNegativos = votosNegativos;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Integer getVotosPositivos() {
		return votosPositivos;
	}

	public void setVotosPositivos(Integer votosPositivos) {
		this.votosPositivos = votosPositivos;
	}

	public Integer getVotosNegativos() {
		return votosNegativos;
	}

	public void setVotosNegativos(Integer votosNegativos) {
		this.votosNegativos = votosNegativos;
	}
	
	

}