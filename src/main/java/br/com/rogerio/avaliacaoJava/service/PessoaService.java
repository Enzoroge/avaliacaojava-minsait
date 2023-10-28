package br.com.rogerio.avaliacaoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rogerio.avaliacaoJava.model.Pessoa;
import br.com.rogerio.avaliacaoJava.repository.PessoaRepository;
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
	public Optional<Pessoa> getById(Long id) {
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
		pessoaRepository.deleteById(id);

	}

}
