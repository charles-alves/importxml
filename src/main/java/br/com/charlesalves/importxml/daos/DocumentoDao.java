package br.com.charlesalves.importxml.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Documento;

@Repository
public interface DocumentoDao extends JpaRepository<Documento, Long> {

	Optional<Documento> findByNumeroOperacao(String numeroOperacao);

}
