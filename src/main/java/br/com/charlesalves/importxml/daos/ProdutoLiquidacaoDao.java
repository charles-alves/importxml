package br.com.charlesalves.importxml.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.charlesalves.importxml.model.ProdutoLiquidacao;

@Repository
public interface ProdutoLiquidacaoDao extends JpaRepository<ProdutoLiquidacao, Long> {

	@Query("SELECT prod.produtosLiquidacao FROM Produto prod WHERE prod.id = :produtoId")
	List<ProdutoLiquidacao> findAllProdutoId(@Param("produtoId") Long produtoId);

}
