package br.com.charlesalves.importxml.model;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "api", name = "produtos_liquidacao")
@SequenceGenerator(schema = "api", name = "id_produtos_liquidacao_seq", sequenceName = "id_produtos_liquidacao_seq")
public class ProdutoLiquidacao {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_produtos_liquidacao_seq")
	private Long id;

	@Column(name = "identificador_linha_bilateral", nullable = false)
	private String identificadorLinhaBilateral;

	@Column(name = "tipo", nullable = false)
	private String tipo;

	@Column(name = "ispb_if_creditada", nullable = false)
	private String ispbIfCreditada;

	@Column(name = "ispb_if_debitada", nullable = false)
	private String ispbIfDebitada;

	@Column(name = "valor_lancamento", nullable = false, columnDefinition = "decimal(10,2)", precision = 10, scale = 2)
	private double valorLancamento;

	@Column(name = "cnpj_nao_liquidante_debito", nullable = false)
	private String cnpjNaoLiquidanteDebito;

	@Column(name = "cliente_debitado", nullable = false)
	private String clienteDebitado;

	@Column(name = "id_cliente_debitado", nullable = true)
	private String idClienteDebitado;

	@Column(name = "cnpj_nao_liquidante_creditado", nullable = false)
	private String cnpjNaoLiquidanteCreditado;

	@Column(name = "nome_cliente_creditado", nullable = false)
	private String nomeClienteCreditado;

	@Column(name = "id_cliente_creditado", nullable = true)
	private String idClienteCreditado;

	@Column(name = "tipo_transacao_slc", nullable = false)
	private String tipoTrasacaoSLC;

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdentificadorLinhaBilateral() {
		return identificadorLinhaBilateral;
	}

	public void setIdentificadorLinhaBilateral(String identificadorLinhaBilateral) {
		this.identificadorLinhaBilateral = identificadorLinhaBilateral;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getIspbIfCreditada() {
		return ispbIfCreditada;
	}

	public void setIspbIfCreditada(String ispbIfCreditada) {
		this.ispbIfCreditada = ispbIfCreditada;
	}

	public String getIspbIfDebitada() {
		return ispbIfDebitada;
	}

	public void setIspbIfDebitada(String ispbIfDebitada) {
		this.ispbIfDebitada = ispbIfDebitada;
	}

	public double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getCnpjNaoLiquidanteDebito() {
		return cnpjNaoLiquidanteDebito;
	}

	public void setCnpjNaoLiquidanteDebito(String cnpjNaoLiquidanteDebito) {
		this.cnpjNaoLiquidanteDebito = cnpjNaoLiquidanteDebito;
	}

	public String getClienteDebitado() {
		return clienteDebitado;
	}

	public void setClienteDebitado(String clienteDebitado) {
		this.clienteDebitado = clienteDebitado;
	}

	public Optional<String> getIdClienteDebitado() {
		return Optional.ofNullable(idClienteDebitado);
	}

	public void setIdClienteDebitado(String idClienteDebitado) {
		this.idClienteDebitado = idClienteDebitado;
	}

	public String getCnpjNaoLiquidanteCreditado() {
		return cnpjNaoLiquidanteCreditado;
	}

	public void setCnpjNaoLiquidanteCreditado(String cnpjNaoLiquidanteCreditado) {
		this.cnpjNaoLiquidanteCreditado = cnpjNaoLiquidanteCreditado;
	}

	public String getNomeClienteCreditado() {
		return nomeClienteCreditado;
	}

	public void setNomeClienteCreditado(String nomeClienteCreditado) {
		this.nomeClienteCreditado = nomeClienteCreditado;
	}

	public Optional<String> getIdClienteCreditado() {
		return Optional.ofNullable(idClienteCreditado);
	}

	public void setIdClienteCreditado(String idClienteCreditado) {
		this.idClienteCreditado = idClienteCreditado;
	}

	public String getTipoTrasacaoSLC() {
		return tipoTrasacaoSLC;
	}

	public void setTipoTrasacaoSLC(String tipoTrasacaoSLC) {
		this.tipoTrasacaoSLC = tipoTrasacaoSLC;
	}
}
