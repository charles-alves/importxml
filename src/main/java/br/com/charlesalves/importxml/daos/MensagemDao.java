package br.com.charlesalves.importxml.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Mensagem;

@Repository
public interface MensagemDao extends JpaRepository<Mensagem, Long> {

	@Query("SELECT doc.mensagens FROM Documento doc WHERE doc.id = :documentoId")
	List<Mensagem> findAllByDocumentoId(@Param("documentoId") Long documentoId);

}
