package br.com.charlesalves.importxml.services;

import java.util.List;
import java.util.Optional;

import br.com.charlesalves.importxml.model.Liquidacao;

public interface LiquidacaoService {

	List<Liquidacao> listarPorMensagem(Long mensagemId);

	List<Liquidacao> listar();

	Optional<Liquidacao> buscar(Long id);

}
