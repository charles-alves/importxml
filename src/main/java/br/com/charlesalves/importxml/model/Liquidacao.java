package br.com.charlesalves.importxml.model;

import java.time.LocalDate;
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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(schema = "api", name = "liquidacoes")
@SequenceGenerator(schema = "api", name = "id_liquidacoes_seq", sequenceName = "id_liquidacoes_seq")
public class Liquidacao {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_liquidacoes_seq")
	private Long id;

	@Column(name = "data", nullable = false)
	private LocalDate data;

	@Column(name = "numero_sequencial", nullable = false)
	private int numeroSequencial;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn(name = "liquidacao_id", nullable = false)
	private List<Produto> produtos = new ArrayList<>();

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroSequencial() {
		return numeroSequencial;
	}

	public void setNumeroSequencial(int numeroSequencial) {
		this.numeroSequencial = numeroSequencial;
	}

	public List<Produto> getProdutos() {
		return getUnmodifiableProdutos();
	}

	public List<Produto> addProduto(Produto produto) {
		produtos.add(produto);

		return getUnmodifiableProdutos();
	}

	public List<Produto> removeProduto(Produto produto) {
		produtos.remove(produto);

		return getUnmodifiableProdutos();
	}

	private List<Produto> getUnmodifiableProdutos() {
		return Collections.unmodifiableList(produtos);
	}
}
