package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.model.Mensagem;

public interface MensagemService {

	List<Mensagem> listar();

	List<Mensagem> listarPorDocumento(Long documentoId);

	Optional<Mensagem> buscar(Long id);

}
