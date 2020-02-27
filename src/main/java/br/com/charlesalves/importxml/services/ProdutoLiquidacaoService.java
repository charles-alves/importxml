package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.model.ProdutoLiquidacao;

public interface ProdutoLiquidacaoService {

	List<ProdutoLiquidacao> listarPorProduto(Long produtoId);

	List<ProdutoLiquidacao> listar();

	Optional<ProdutoLiquidacao> buscar(Long id);

}
