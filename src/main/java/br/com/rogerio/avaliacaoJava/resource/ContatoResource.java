package br.com.rogerio.avaliacaoJava.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerio.avaliacaoJava.model.Contato;
import br.com.rogerio.avaliacaoJava.service.ContatoService;

@RestController
@RequestMapping(value = "/api/contatos")
public class ContatoResource {

	private ContatoService contatoService;

	@Autowired
	public ContatoResource(ContatoService contatoService) {
		this.contatoService = contatoService;
	}

	@PostMapping(value = "/api/pessoas/{id}/contatos")
	public ResponseEntity<Contato> save(@RequestBody Contato obj) {
		return new ResponseEntity<>(contatoService.save(obj), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Contato>> getAll() {
		List<Contato> contato = contatoService.getAll();
		if (contato == null) {
			return ResponseEntity.notFound().build();

		}
		return ResponseEntity.ok().body(contato);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Contato>> getById(@PathVariable Long id) {
		Optional<Contato> contato = contatoService.getById(id);
		if (contato == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(contato);
	}
	
	@PutMapping
	public ResponseEntity<Contato> update(@RequestBody Contato contato){
		return new ResponseEntity(contatoService.update(contato), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value="/api/contatos/{id}")
		public ResponseEntity<?> delete(@PathVariable Long id){
			contatoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		
	}

}
