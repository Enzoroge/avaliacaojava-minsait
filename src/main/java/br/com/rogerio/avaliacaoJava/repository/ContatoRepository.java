package br.com.rogerio.avaliacaoJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.rogerio.avaliacaoJava.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long>{

}
