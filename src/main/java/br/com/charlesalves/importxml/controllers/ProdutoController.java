package br.com.charlesalves.importxml.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesalves.importxml.model.Produto;
import br.com.charlesalves.importxml.services.ProdutoService;

@RestController
public class ProdutoController {

	private ProdutoService produtoService;

	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@GetMapping("liquidacoes/{liquidacaoId}/produtos")
	public ResponseEntity<List<Produto>> listarPorLiquidacao(@PathVariable("liquidacaoId") Long liquidacaoId) {
		List<Produto> produtos = produtoService.listarPorLiquidacaoId(liquidacaoId);

		return ResponseEntity.ok(produtos);
	}

	@GetMapping("produtos")
	public ResponseEntity<List<Produto>> listar() {
		List<Produto> produtos = produtoService.listar();

		return ResponseEntity.ok(produtos);
	}

	@GetMapping("produtos/{id}")
	public ResponseEntity<Produto> buscar(@PathVariable("id") Long id) {
		Optional<Produto> produtoOpt = produtoService.buscar(id);

		return produtoOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
