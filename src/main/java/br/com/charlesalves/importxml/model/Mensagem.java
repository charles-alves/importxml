package br.com.charlesalves.importxml.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
@Table(schema = "api", name = "mensagens")
@SequenceGenerator(schema = "api", name = "id_mensagens_seq", sequenceName = "id_mensagens_seq")
public class Mensagem {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_mensagens_seq")
	private Long id;

	@Column(name = "codigo_mensagem", nullable = false, unique = true)
	private String codigoMensagem;

	@Column(name = "numero_controle_slc", nullable = false)
	private String numeroControleSLC;

	@Column(name = "ispbIf", nullable = false)
	private String ispbIf;

	@Column(name = "tipo_informacao", nullable = false)
	private String tipoInformacao;

	@Column(name = "data_hora_slc", nullable = false)
	private LocalDateTime dataHoraSLC;

	@Column(name = "data_movimento", nullable = false)
	private LocalDate dataMovimento;

	@OneToMany
	@JoinColumn(name = "mensagem_id", nullable = false)
	private List<Liquidacao> liquidacoes = new ArrayList<>();

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoMensagem() {
		return codigoMensagem;
	}

	public void setCodigoMensagem(String codigoMensagem) {
		this.codigoMensagem = codigoMensagem;
	}

	public String getNumeroControleSLC() {
		return numeroControleSLC;
	}

	public void setNumeroControleSLC(String numeroControleSLC) {
		this.numeroControleSLC = numeroControleSLC;
	}

	public String getIspbIf() {
		return ispbIf;
	}

	public void setIspbIf(String ispbIf) {
		this.ispbIf = ispbIf;
	}

	public String getTipoInformacao() {
		return tipoInformacao;
	}

	public void setTipoInformacao(String tipoInformacao) {
		this.tipoInformacao = tipoInformacao;
	}

	public LocalDateTime getDataHoraSLC() {
		return dataHoraSLC;
	}

	public void setDataHoraSLC(LocalDateTime dataHoraSLC) {
		this.dataHoraSLC = dataHoraSLC;
	}

	public LocalDate getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDate dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public List<Liquidacao> getLiquidacoes() {
		return getUnmodifiableLiquidacoes();
	}

	public List<Liquidacao> addLiquidacao(Liquidacao liquidacao) {
		liquidacoes.add(liquidacao);

		return getUnmodifiableLiquidacoes();
	}

	public List<Liquidacao> removeLiquidacao(Liquidacao liquidacao) {
		liquidacoes.remove(liquidacao);

		return getUnmodifiableLiquidacoes();
	}

	private List<Liquidacao> getUnmodifiableLiquidacoes() {
		return Collections.unmodifiableList(liquidacoes);
	}
}
