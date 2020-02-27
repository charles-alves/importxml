package br.com.charlesalves.importxml.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.charlesalves.importxml.model.Documento;
import br.com.charlesalves.importxml.services.DocumentoService;

@RestController
@RequestMapping("documentos")
public class DocumentoController {

	private DocumentoService documentoService;

	public DocumentoController(DocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	@GetMapping
	public ResponseEntity<List<Documento>> list() {
		List<Documento> documentos = documentoService.listar();

		return ResponseEntity.ok(documentos);
	}

	@GetMapping("{id}")
	public ResponseEntity<Documento> buscar(@PathVariable(value = "id", required = true) Long documentoID) {
		Optional<Documento> documentoOpt = documentoService.buscar(documentoID);

		return documentoOpt
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping(params = { "numeroOperacao" })
	public ResponseEntity<Documento> buscarPorNumeroOperacao(
			@RequestParam(value = "numeroOperacao", required = false) String numeroOperacao) {
		Optional<Documento> documentoOpt = documentoService.buscarPorNumeroOperacao(numeroOperacao);

		return documentoOpt
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Void> salvar(@RequestParam(value = "arquivo", required = true) MultipartFile arquivo)
			throws IOException {
		InputStream is = arquivo.getInputStream();

		Documento documento = documentoService.processar(is);
		documento = documentoService.salvar(documento);

		return ResponseEntity.ok(null);
	}
}
