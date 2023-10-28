package br.com.rogerio.avaliacaoJava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.rogerio.avaliacaoJava.model.Contato;
import br.com.rogerio.avaliacaoJava.repository.ContatoRepository;

@Service
public class ContatoService implements ContatoServiceInterface {

	private ContatoRepository contatoRepository;

	public ContatoService(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}

	@Override
	public Contato save(Contato contato) {

		return contatoRepository.save(contato);
	}

	@Override
	public Optional<Contato> getById(Long id) {
		return contatoRepository.findById(id);
	}

	@Override
	public List<Contato> getAll() {
		return contatoRepository.findAll();
	}

	@Override
	public Contato update(Contato contato) {
		Optional<Contato> upContato = contatoRepository.findById(contato.getId());
		if(upContato.isPresent()){
			Contato newContato = upContato.get();
			newContato.setContato(contato.getContato());
			newContato.setTipoContato(contato.getTipoContato());
			newContato.setPessoa(contato.getPessoa());
			return contatoRepository.save(newContato);
		}
		return contato;
	}

	@Override
	public void delete(Long id) {
		contatoRepository.deleteById(id);

	}

}
