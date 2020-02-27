package br.com.charlesalves.importxml.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.charlesalves.importxml.model.Mensagem;
import br.com.charlesalves.importxml.services.MensagemService;

@RestController
public class MensagemController {

	private MensagemService mensagemService;

	public MensagemController(MensagemService mensagemService) {
		this.mensagemService = mensagemService;
	}

	@GetMapping("documentos/{documentoId}/mensagens")
	public ResponseEntity<List<Mensagem>> listarPorDocumento(@PathVariable("documentoId") Long documentoId) {
		List<Mensagem> mensagens = mensagemService.listarPorDocumento(documentoId);

		return ResponseEntity.ok(mensagens);
	}

	@GetMapping("mensagens")
	public ResponseEntity<List<Mensagem>> listar() {
		List<Mensagem> mensagens = mensagemService.listar();

		return ResponseEntity.ok(mensagens);
	}

	public ResponseEntity<Mensagem> buscar(@PathVariable("id") Long id) {
		Optional<Mensagem> mensagemOpt = mensagemService.buscar(id);

		return mensagemOpt.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
}
