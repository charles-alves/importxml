package br.com.charlesalves.importxml.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Liquidacao;

@Repository
public interface LiquidacaoDao extends JpaRepository<Liquidacao, Long> {

	@Query("SELECT mes.liquidacoes FROM Mensagem mes WHERE mes.id = :mensagemId")
	List<Liquidacao> findAllByMensagemId(@Param("mensagemId") Long mensagemId);

}
