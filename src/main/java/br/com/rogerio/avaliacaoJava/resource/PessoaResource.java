package br.com.rogerio.avaliacaoJava.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rogerio.avaliacaoJava.service.PessoaService;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaResource {
	
	private PessoaService pessoaService;
	
	@Autowired
	public PessoaResource(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}
	
	

}
