package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.daos.MensagemDao;
import br.com.charlesalves.importxml.model.Mensagem;

public class MensagemServiceImpl implements MensagemService {

	private MensagemDao mensagemDao;

	public MensagemServiceImpl(MensagemDao mensagemDao) {
		this.mensagemDao = mensagemDao;
	}

	@Override
	public List<Mensagem> listar() {
		return mensagemDao.findAll();
	}

	@Override
	public List<Mensagem> listarPorDocumento(Long documentoId) {
		return mensagemDao.findAllByDocumentoId(documentoId);
	}

	@Override
	public Optional<Mensagem> buscar(Long id) {
		return mensagemDao.findById(id);
	}

}
