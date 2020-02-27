package br.com.charlesalves.importxml.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesalves.importxml.model.ProdutoLiquidacao;
import br.com.charlesalves.importxml.services.ProdutoLiquidacaoService;

@RestController
public class ProdutoLiquidacaoController {

	private ProdutoLiquidacaoService produtoLiquidacaoService;

	public ProdutoLiquidacaoController(ProdutoLiquidacaoService produtoLiquidacaoService) {
		this.produtoLiquidacaoService = produtoLiquidacaoService;
	}

	@GetMapping("produtos/{produtoId}/produtos-liquidacao")
	public ResponseEntity<List<ProdutoLiquidacao>> listarPorDocumento(@PathVariable("produtoId") Long produtoId) {
		List<ProdutoLiquidacao> produtosLiquidacao = produtoLiquidacaoService.listarPorProduto(produtoId);

		return ResponseEntity.ok(produtosLiquidacao);
	}

	@GetMapping("produtos-liquidacao")
	public ResponseEntity<List<ProdutoLiquidacao>> listar() {
		List<ProdutoLiquidacao> produtosLiquidacao = produtoLiquidacaoService.listar();

		return ResponseEntity.ok(produtosLiquidacao);
	}

	@GetMapping("produtos-liquidacao/{id}")
	public ResponseEntity<ProdutoLiquidacao> buscar(@PathVariable("id") Long id) {
		Optional<ProdutoLiquidacao> produtoLiquidacaoOpt = produtoLiquidacaoService.buscar(id);

		return produtoLiquidacaoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

}
