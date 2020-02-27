package br.com.charlesalves.importxml.services;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import br.com.charlesalves.importxml.daos.DocumentoDao;
import br.com.charlesalves.importxml.model.Documento;
import br.com.charlesalves.importxml.model.Liquidacao;
import br.com.charlesalves.importxml.model.Mensagem;
import br.com.charlesalves.importxml.model.Produto;
import br.com.charlesalves.importxml.model.ProdutoLiquidacao;

@Service
public class DocumentoServiceImpl implements DocumentoService {

	private DocumentoDao documentoDao;

	public DocumentoServiceImpl(DocumentoDao documentoDao) {
		this.documentoDao = documentoDao;
	}

	@Override
	public Documento processar(InputStream is) {
		try {
			Document doc = readXml(is);

			Node bcmsg = doc.getElementsByTagName("BCMSG").item(0);
			Node sismsg = doc.getElementsByTagName("SISMSG").item(0);

			Documento documento = criarDocumento(bcmsg);
			Mensagem mensagem = criarMensagem(sismsg);

			documento.setMensagem(mensagem);

			return documento;
		} catch (ParserConfigurationException | SAXException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private Document readXml(InputStream is) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

		Document doc = dBuilder.parse(is);
		doc.getDocumentElement().normalize();

		return doc;
	}

	private Documento criarDocumento(Node bcmsg) {
		Documento documento = new Documento();

		NodeList bcmsgChildren = bcmsg.getChildNodes();

		for (int i = 0; i < bcmsgChildren.getLength(); i++) {
			Node node = bcmsgChildren.item(i);
			String nodeName = node.getNodeName();
			String nodeValue = node.getTextContent();

			if (nodeName.equals("IdentdEmissor")) {
				documento.setIdEmissor(nodeValue);
			} else if (nodeName.equals("IdentdDestinatario")) {
				documento.setIdDestinatario(nodeValue);
			} else if (nodeName.equals("IdentdContg")) {
				documento.setIdContigencia(nodeValue);
			} else if (nodeName.equals("IdentdOperad")) {
				documento.setIdOperador(nodeValue);
			} else if (nodeName.equals("IdentdOperadConfc")) {
				documento.setIdOperadorConfirmacao(nodeValue);
			} else if (nodeName.equals("DomSist")) {
				documento.setSistema(nodeValue);
			} else if (nodeName.equals("NUOp")) {
				documento.setNumeroOperacao(nodeValue);
			}
		}

		return documento;
	}

	private Mensagem criarMensagem(Node sismsg) {
		Mensagem mensagem = new Mensagem();

		Node slc0001 = sismsg.getChildNodes().item(1);
		NodeList slc0001Children = slc0001.getChildNodes();

		for (int i = 0; i < slc0001Children.getLength(); i++) {
			Node node = slc0001Children.item(i);
			String nodeName = node.getNodeName();
			String nodeValue = node.getTextContent();

			if (nodeName.equals("CodMsg")) {
				mensagem.setCodigoMensagem(nodeValue);
			} else if (nodeName.equals("NumCtrlSLC")) {
				mensagem.setNumeroControleSLC(nodeValue);
			} else if (nodeName.equals("ISPBIF")) {
				mensagem.setIspbIf(nodeValue);
			} else if (nodeName.equals("TpInf")) {
				mensagem.setTipoInformacao(nodeValue);
			} else if (nodeName.equals("DtHrSLC")) {
				LocalDateTime dataHoraSLC = LocalDateTime.parse(nodeValue);

				mensagem.setDataHoraSLC(dataHoraSLC);
			} else if (nodeName.equals("DtMovto")) {
				LocalDate dataMovimento = LocalDate.parse(nodeValue);

				mensagem.setDataMovimento(dataMovimento);
			} else if (nodeName.contentEquals("Grupo_SLC0001_Liquid")) {
				Liquidacao liquidacao = criarLiquidacao(node.getChildNodes());

				mensagem.addLiquidacao(liquidacao);
			}
		}
		return mensagem;
	}

	private Liquidacao criarLiquidacao(NodeList liquidacaoNodes) {
		Liquidacao liquidacao = new Liquidacao();

		for (int i = 0; i < liquidacaoNodes.getLength(); i++) {
			Node node = liquidacaoNodes.item(i);
			String nodeName = node.getNodeName();
			String nodeValue = node.getTextContent();

			if (nodeName.equals("DtLiquid")) {
				LocalDate data = LocalDate.parse(nodeValue);

				liquidacao.setData(data);
			} else if (nodeName.equals("NumSeqCicloLiquid")) {
				int numeroSequencial = Integer.parseInt(nodeValue);

				liquidacao.setNumeroSequencial(numeroSequencial);
			} else if (nodeName.equals("Grupo_SLC0001_Prodt")) {
				Produto produto = criarProduto(node.getChildNodes());

				liquidacao.addProduto(produto);
			}
		}

		return liquidacao;
	}

	private Produto criarProduto(NodeList childNodes) {
		Produto produto = new Produto();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			String nodeName = node.getNodeName();
			String nodeValue = node.getTextContent();

			if (nodeName.equals("CodProdt")) {
				produto.setCodigo(nodeValue);
			} else if (nodeName.equals("Grupo_SLC0001_LiquidProdt")) {
				ProdutoLiquidacao produtoLiquidacao = criarProdutoLiquidacao(node.getChildNodes());

				produto.addProdutoLiquidacoao(produtoLiquidacao);
			}
		}

		return produto;
	}

	private ProdutoLiquidacao criarProdutoLiquidacao(NodeList childNodes) {
		ProdutoLiquidacao produtoLiquidacao = new ProdutoLiquidacao();

		for (int i = 0; i < childNodes.getLength(); i++) {
			Node node = childNodes.item(i);
			String nodeName = node.getNodeName();
			String nodeValue = node.getTextContent();

			if (nodeName.equals("IdentdLinhaBilat")) {
				produtoLiquidacao.setIdentificadorLinhaBilateral(nodeValue);
			} else if (nodeName.equals("TpDeb_Cred")) {
				produtoLiquidacao.setTipo(nodeValue);
			} else if (nodeName.equals("ISPBIFCredtd")) {
				produtoLiquidacao.setIspbIfCreditada(nodeValue);
			} else if (nodeName.equals("ISPBIFDebtd")) {
				produtoLiquidacao.setIspbIfDebitada(nodeValue);
			} else if (nodeName.equals("VlrLanc")) {
				double valorLancamento = Double.parseDouble(nodeValue);

				produtoLiquidacao.setValorLancamento(valorLancamento);
			} else if (nodeName.equals("CNPJNLiqdantDebtd")) {
				produtoLiquidacao.setCnpjNaoLiquidanteDebito(nodeValue);
			} else if (nodeName.equals("NomCliDebtd")) {
				produtoLiquidacao.setNomeClienteDebitado(nodeValue);
			} else if (nodeName.equals("IdentdPessoaCliDebtd")) {
				produtoLiquidacao.setIdClienteDebitado(nodeValue);
			} else if (nodeName.equals("CNPJNLiqdantCredtd")) {
				produtoLiquidacao.setCnpjNaoLiquidanteCreditado(nodeValue);
			} else if (nodeName.equals("NomCliCredtd")) {
				produtoLiquidacao.setNomeClienteCreditado(nodeValue);
			} else if (nodeName.equals("IdentdPessoaCliCredtd")) {
				produtoLiquidacao.setIdClienteCreditado(nodeValue);
			} else if (nodeName.equals("TpTranscSLC")) {
				produtoLiquidacao.setTipoTrasacaoSLC(nodeValue);
			}
		}

		return produtoLiquidacao;
	}

	@Override
	public List<Documento> listar() {
		return documentoDao.findAll();
	}

	@Override
	public Optional<Documento> buscar(Long documentoId) {
		if (Objects.isNull(documentoId)) {
			return Optional.empty();
		}

		return documentoDao.findById(documentoId);
	}

	@Override
	public Optional<Documento> buscarPorNumeroOperacao(String numeroOperacao) {
		return documentoDao.findByNumeroOperacao(numeroOperacao);
	}

	@Override
	public Documento salvar(Documento documento) {
		return documentoDao.save(documento);
	}
}
