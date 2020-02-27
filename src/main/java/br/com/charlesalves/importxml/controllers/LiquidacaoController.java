package br.com.charlesalves.importxml.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesalves.importxml.model.Liquidacao;
import br.com.charlesalves.importxml.services.LiquidacaoService;

@RestController
public class LiquidacaoController {

	private LiquidacaoService liquidacaoService;

	public LiquidacaoController(LiquidacaoService liquidacaoService) {
		this.liquidacaoService = liquidacaoService;
	}

	@GetMapping("mensagens/{mensagemId}/liquidacoes")
	public ResponseEntity<List<Liquidacao>> listarPorDocumento(@PathVariable("mensagemId") Long mensagemId) {
		List<Liquidacao> liquidacoes = liquidacaoService.listarPorMensagem(mensagemId);

		return ResponseEntity.ok(liquidacoes);
	}

	@GetMapping("liquidacoes")
	public ResponseEntity<List<Liquidacao>> listar() {
		List<Liquidacao> liquidacoes = liquidacaoService.listar();

		return ResponseEntity.ok(liquidacoes);
	}

	@GetMapping("liquidacoes/{id}")
	public ResponseEntity<Liquidacao> buscar(@PathVariable("id") Long id) {
		Optional<Liquidacao> liquidacaoOpt = liquidacaoService.buscar(id);

		return liquidacaoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
