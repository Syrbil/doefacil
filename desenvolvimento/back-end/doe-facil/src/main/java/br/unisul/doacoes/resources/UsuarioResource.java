package br.unisul.doacoes.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unisul.doacoes.domain.Doacao;
import br.unisul.doacoes.domain.Notificacao;
import br.unisul.doacoes.domain.Usuario;
import br.unisul.doacoes.dtos.DoacaoDTO;
import br.unisul.doacoes.dtos.NotificacaoDTO;
import br.unisul.doacoes.dtos.UsuarioDTO;
import br.unisul.doacoes.services.DoacaoService;
import br.unisul.doacoes.services.NotificacaoService;
import br.unisul.doacoes.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@Autowired
	private NotificacaoService notificacaoService;
	
	@Autowired
	private DoacaoService doacaoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> find(@PathVariable Integer id) {
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//LOGIN
	@RequestMapping(value = "/{nomeUsuario}/{senha}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> login(@PathVariable String nomeUsuario, @PathVariable String senha) {
		Usuario obj = service.login(nomeUsuario,senha);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Usuario obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdUsuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Usuario obj, @PathVariable Integer id) {
		obj.setIdUsuario(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = service.findAll();
		List<UsuarioDTO> listaDTO = lista.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	//listar notificacoes de um usuario
	@RequestMapping(value="/{usuarioId}/notificacoes", method=RequestMethod.GET)
	public ResponseEntity<List<NotificacaoDTO>> findNotificacoes(@PathVariable Integer usuarioId) {
		List<Notificacao> list = notificacaoService.findByUsuario(usuarioId);
		List<NotificacaoDTO> listDto = list.stream().map(obj -> new NotificacaoDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	//listar DOAÇOES FEITAS de um usuario
		@RequestMapping(value="/{usuarioId}/doacoesfeitas", method=RequestMethod.GET)
		public ResponseEntity<List<DoacaoDTO>> findFeitas(@PathVariable Integer usuarioId) {
			List<Doacao> list = doacaoService.findByDoador(usuarioId);
			List<DoacaoDTO> listDto = list.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(listDto);
		}
		
		//listar DOAÇOES RECEBIDAS de um usuario
		@RequestMapping(value="/{usuarioId}/doacoesrecebidas", method=RequestMethod.GET)
		public ResponseEntity<List<DoacaoDTO>> findRecebidas(@PathVariable Integer usuarioId) {
			List<Doacao> list = doacaoService.findByRecebedor(usuarioId);
			List<DoacaoDTO> listDto = list.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(listDto);
		}
		
		//listar DOAÇOES FEITAS E QUE ESTÃO DISPONIVEIS de um usuario
		@RequestMapping(value="/{usuarioId}/doacoesfeitasdisponiveis", method=RequestMethod.GET)
		public ResponseEntity<List<DoacaoDTO>> findFeitasDisponiveis(@PathVariable Integer usuarioId) {
			List<Doacao> list = doacaoService.findByDoadorDisponiveis(usuarioId);
			List<DoacaoDTO> listDto = list.stream().map(obj -> new DoacaoDTO(obj)).collect(Collectors.toList());  
			return ResponseEntity.ok().body(listDto);
			}
		


}