package br.unisul.doacoes.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.dtos.DoacaoDTO;
import br.unisul.doacoes.resources.utils.URL;
import br.unisul.doacoes.services.DoacaoService;

@RestController
@RequestMapping(value = "/doacoes")
public class DoacaoResource {
	@Autowired
	private DoacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Doacao> find(@PathVariable Integer id) {
		Doacao obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Doacao obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Doacao obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Doacao id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<DoacaoDTO>> findAll() {
		List<Doacao> lista = service.findDisponiveis();
		List<DoacaoDTO> listaDTO = lista.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	//filtrar doacoes pela categoria
	@RequestMapping(value = "/categoria/{categoria}", method = RequestMethod.GET)
	public ResponseEntity<List<DoacaoDTO>> findByCategoria(@PathVariable String categoria) {
		List<Doacao> lista = service.findByCategoria(categoria);
		List<DoacaoDTO> listaDTO = lista.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	// Encontrar doações por trechos de nome
		@RequestMapping(value = "/filtro", method = RequestMethod.GET)
		public ResponseEntity<List<DoacaoDTO>> filtrarPorNome(@RequestParam(value = "nome", defaultValue = "") String nome) {
			List<DoacaoDTO> listaDTO = new ArrayList<DoacaoDTO>();
			String nomeDecoded = URL.decodeParam(nome);
			List<Doacao> lista = service.findByNome(nomeDecoded);
			for (Doacao d : lista) {
				listaDTO.add(new DoacaoDTO(d));
			}
			return ResponseEntity.ok().body(listaDTO);
		}


}