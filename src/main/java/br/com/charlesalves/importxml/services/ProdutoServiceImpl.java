package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.charlesalves.importxml.daos.ProdutoDao;
import br.com.charlesalves.importxml.model.Produto;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private ProdutoDao produtoDao;

	public ProdutoServiceImpl(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	@Override
	public List<Produto> listarPorLiquidacaoId(Long liquidacaoId) {
		return produtoDao.findAllByLiquidacaoId(liquidacaoId);
	}

	@Override
	public List<Produto> listar() {
		return produtoDao.findAll();
	}

	@Override
	public Optional<Produto> buscar(Long id) {
		return produtoDao.findById(id);
	}
}
