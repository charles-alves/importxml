package br.com.charlesalves.importxml.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.Produto;

@Repository
public interface ProdutoDao extends JpaRepository<Produto, Long> {

	@Query("SELECT liq.produtos FROM Liquidacao liq WHERE liq.id = :liquidacaoId")
	List<Produto> findAllByLiquidacaoId(@Param("liquidacaoId") Long liquidacaoId);

}
