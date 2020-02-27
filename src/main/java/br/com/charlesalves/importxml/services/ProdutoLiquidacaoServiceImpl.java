package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.charlesalves.importxml.daos.ProdutoLiquidacaoDao;
import br.com.charlesalves.importxml.model.ProdutoLiquidacao;

@Service
public class ProdutoLiquidacaoServiceImpl implements ProdutoLiquidacaoService {

	private ProdutoLiquidacaoDao produtoLiquidacaoDao;

	public ProdutoLiquidacaoServiceImpl(ProdutoLiquidacaoDao produtoLiquidacaoDao) {
		this.produtoLiquidacaoDao = produtoLiquidacaoDao;
	}

	@Override
	public List<ProdutoLiquidacao> listarPorProduto(Long produtoId) {
		return produtoLiquidacaoDao.findAllProdutoId(produtoId);
	}

	@Override
	public List<ProdutoLiquidacao> listar() {
		return produtoLiquidacaoDao.findAll();
	}

	@Override
	public Optional<ProdutoLiquidacao> buscar(Long id) {
		return produtoLiquidacaoDao.findById(id);
	}

}
