package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.charlesalves.importxml.daos.LiquidacaoDao;
import br.com.charlesalves.importxml.model.Liquidacao;

@Service
public class LiquidacaoServiceImpl implements LiquidacaoService {

	private LiquidacaoDao liquidacaoDao;

	public LiquidacaoServiceImpl(LiquidacaoDao liquidacaoDao) {
		this.liquidacaoDao = liquidacaoDao;
	}

	@Override
	public List<Liquidacao> listarPorMensagem(Long mensagemId) {
		return liquidacaoDao.findAllByMensagemId(mensagemId);
	}

	@Override
	public List<Liquidacao> listar() {
		return liquidacaoDao.findAll();
	}

	@Override
	public Optional<Liquidacao> buscar(Long id) {
		return liquidacaoDao.findById(id);
	}
}
