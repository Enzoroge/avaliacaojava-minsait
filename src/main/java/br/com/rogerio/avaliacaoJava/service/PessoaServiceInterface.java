package br.com.rogerio.avaliacaoJava.service;

import java.util.List;
import java.util.Optional;


import br.com.rogerio.avaliacaoJava.model.Pessoa;

public interface PessoaServiceInterface {

	Pessoa save(Pessoa contato);

	Optional<Pessoa> getById(Long id);

	List<Pessoa> getAll();

	Pessoa update(Pessoa contato);

	void delete(Long id);

}
