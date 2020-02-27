package br.com.charlesalves.importxml.services;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.model.Documento;

public interface DocumentoService {

	Documento processar(InputStream is);

	List<Documento> listar();

	Optional<Documento> buscar(Long documentoID);

	Optional<Documento> buscarPorNumeroOperacao(String numeroOperacao);

	Documento salvar(Documento documento);

}
