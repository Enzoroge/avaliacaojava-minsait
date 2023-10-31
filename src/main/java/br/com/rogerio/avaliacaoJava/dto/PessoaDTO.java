package br.com.rogerio.avaliacaoJava.dto;

public record PessoaDTO(
		Long id, 
		String nome,  
		String malaDireta) 


{
	
	
	 private String malaDireta(String endereco, String cep, String cidade, String uf) {
	        return endereco + " - CEP: " + cep + " - " + cidade + "/" + uf;
	    }
	 

}
