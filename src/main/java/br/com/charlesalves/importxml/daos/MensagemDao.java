package br.com.charlesalves.importxml.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Mensagem;

@Repository
public interface MensagemDao extends JpaRepository<Mensagem, Long> {

}
