package br.com.charlesalves.importxml.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "api", name = "produtos")
@SequenceGenerator(schema = "api", name = "id_produtos_seq", sequenceName = "id_produtos_seq")
public class Produto {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_produtos_seq")
	private Long id;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
	@JoinColumn(name = "produto_id", nullable = false)
	private List<ProdutoLiquidacao> produtosLiquidacao = new ArrayList<>();

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<ProdutoLiquidacao> getProdutosLiquidacao() {
		return getUnmodifiableProdutosLiquidacao();
	}

	public List<ProdutoLiquidacao> addProdutoLiquidacoao(ProdutoLiquidacao produtoLiquidacao) {
		produtosLiquidacao.add(produtoLiquidacao);

		return getUnmodifiableProdutosLiquidacao();
	}

	public List<ProdutoLiquidacao> removeProdutoLiquidacoao(ProdutoLiquidacao produtoLiquidacao) {
		produtosLiquidacao.remove(produtoLiquidacao);

		return getUnmodifiableProdutosLiquidacao();
	}

	private List<ProdutoLiquidacao> getUnmodifiableProdutosLiquidacao() {
		return Collections.unmodifiableList(produtosLiquidacao);
	}
}
