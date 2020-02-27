package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.model.Produto;

public interface ProdutoService {

	List<Produto> listarPorLiquidacaoId(Long liquidacaoId);

	List<Produto> listar();

	Optional<Produto> buscar(Long id);

}
