package br.unisul.doacoes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.repositories.DoacaoRepository;

@Service
public class DoacaoService {

	@Autowired
	private DoacaoRepository rep;
	
	@Autowired
	private UsuarioService service;
	
	public List<Doacao> findByNome(String nome) {
		return rep.findByDoacaoContaining(nome);
	}

	public List<Doacao> findByCategoria(String cat) {
		return rep.findByCategoria(cat);
	}
	
	public List<Doacao> findByDoador(Integer doadorId) {
		return rep.findFeitas(doadorId);
	}
	
	public List<Doacao> findByDoadorDisponiveis(Integer doadorId) {
		return rep.findFeitasDisponiveis(doadorId);
	}
	
	public List<Doacao> findByRecebedor(Integer recebedorId) {
		return rep.findRecebidas(recebedorId);
	}
	
	public Doacao findById(Integer id) {
		Optional<Doacao> obj = rep.findById(id);
		return obj.orElse(null);
	}

	public Doacao insert(Doacao obj) {
		obj.setId(null);
		obj.setDoador(service.findById(obj.getDoador().getIdUsuario()));
		obj.setRecebedor(null);
		rep.save(obj);
		return obj;
	}

	public Doacao update(Doacao obj) {
		findById(obj.getId());
		return rep.save(obj);
	}

	public List<Doacao> findDisponiveis() {
		return rep.findDisponiveis();
	}

	public void delete(Doacao id) {
		findById(id.getId());
		rep.deleteById(id.getId());
	}

}