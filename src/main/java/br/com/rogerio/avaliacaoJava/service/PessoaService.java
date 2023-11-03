package br.com.rogerio.avaliacaoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.rogerio.avaliacaoJava.dto.PessoaDTO;
import br.com.rogerio.avaliacaoJava.model.Pessoa;
import br.com.rogerio.avaliacaoJava.repository.PessoaRepository;
import br.com.rogerio.avaliacaoJava.service.exceptions.DataBaseException;
import br.com.rogerio.avaliacaoJava.service.exceptions.ResourceNotFoundException;
import br.com.rogerio.avaliacaoJava.service.interfaces.PessoaServiceInterface;

@Service
public class PessoaService implements PessoaServiceInterface {

	private PessoaRepository pessoaRepository;

	public PessoaService(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Optional<PessoaDTO> getById(Long id) {
		return Optional.empty();
	}
	
	@Override
	public Optional<Pessoa> getById1(Long id){
		return pessoaRepository.findById(id);
	}

	@Override
	public List<Pessoa> getAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa update(Pessoa pessoa) {
		Optional<Pessoa> upPessoa = pessoaRepository.findById(pessoa.getId());
		if (upPessoa.isPresent()) {
			Pessoa newPessoa = upPessoa.get();
			newPessoa.setCep(pessoa.getCep());
			newPessoa.setCidade(pessoa.getCidade());
			newPessoa.setEndereco(pessoa.getEndereco());
			newPessoa.setNome(pessoa.getNome());
			newPessoa.setUf(pessoa.getUf());
			return pessoaRepository.save(newPessoa);
		}
		return pessoa;
	}

	@Override
	public void delete(Long id) {
		try {
		pessoaRepository.deleteById(id);
		}catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);	
		}catch (DataIntegrityViolationException e) {
		throw new 	DataBaseException(e.getMessage());	
		}
	}

	public Optional<Pessoa> findById(Long id) {
		return pessoaRepository.findById(id);
	}

}