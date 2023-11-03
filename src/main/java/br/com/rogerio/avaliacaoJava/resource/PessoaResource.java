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

import br.com.rogerio.avaliacaoJava.dto.PessoaDTO;
import br.com.rogerio.avaliacaoJava.model.Pessoa;
import br.com.rogerio.avaliacaoJava.service.PessoaService;
import br.com.rogerio.avaliacaoJava.service.exceptions.ObjectNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	private PessoaService pessoaService;

	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@Operation(summary = "Método para cadastrar pessoas")
	@PostMapping
	public ResponseEntity<Pessoa> save(@Valid @RequestBody Pessoa pessoa) {
		Pessoa novaPessoa = pessoaService.save(pessoa);
		if (novaPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<>(pessoaService.save(pessoa), HttpStatus.CREATED);
	}

	@Operation(summary = "Método para buscar pessoas pelo Id")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Pessoa>> findById1(@PathVariable Long id) {
		Optional<Pessoa> obj = pessoaService.findById(id);
		if (obj.isEmpty()) {
			 throw new ObjectNotFoundException("Pessoa não encontrada com o ID: " + id);
		}

		return ResponseEntity.ok().body(obj);
	}

	@Operation(summary = "Método para listar todas as pessoas")
	@GetMapping
	public ResponseEntity<List<Pessoa>> getAllPessoas() {
		List<Pessoa> pessoa = pessoaService.getAll();
		if (pessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(pessoa);
	}

	@Operation(summary = "Reotornar os dados de uma pessoa por Id para Mala Direta")
	@GetMapping("/maladireta/{id}")
	public ResponseEntity<PessoaDTO> getPessoaForMalaDireta(@PathVariable Long id) {
		Optional<Pessoa> pessoaOptional = pessoaService.findById(id);

		if (pessoaOptional.isPresent()) {
			Pessoa pessoa = pessoaOptional.get();
			String malaDireta = pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/"
					+ pessoa.getUf();
			PessoaDTO pessoaDTO = new PessoaDTO(pessoa.getId(), pessoa.getNome(), malaDireta);
			return ResponseEntity.ok(pessoaDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@Operation(summary = "Método para atualizar uma pessoa existente")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Pessoa> update(@RequestBody Pessoa pessoa) {
		Pessoa novaPessoa = pessoaService.update(pessoa);
		if (novaPessoa == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(novaPessoa);
	}

	@Operation(summary = "Método para deletar uma pessoa")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		pessoaService.delete(id);

	}

}
