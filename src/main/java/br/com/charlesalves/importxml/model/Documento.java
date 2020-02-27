package br.com.charlesalves.importxml.model;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "documentos", schema = "api")
@SequenceGenerator(schema = "api", name = "id_ducumentos_seq", sequenceName = "id_ducumentos_seq")
public class Documento {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_ducumentos_seq")
	private Long id;

	@Column(name = "numero_operacao", nullable = false, length = 23)
	private String numeroOperacao;

	@Column(name = "id_emissor", nullable = false, length = 8)
	private String idEmissor;

	@Column(name = "id_destinatario", nullable = false, length = 8)
	private String idDestinatario;

	@Column(name = "sistema", nullable = false)
	private String sistema;

	@Column(name = "id_contigencia", nullable = true, length = 8)
	private String idContigencia;

	@Column(name = "id_operador", nullable = true)
	private String idOperador;

	@Column(name = "id_operador_confirmacao", nullable = true)
	private String idOperadorConfirmacao;

	@JsonIgnore
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE })
	@JoinColumn(name = "mensagem_id", table = "documentos", nullable = false)
	private Mensagem mensagem;

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroOperacao() {
		return numeroOperacao;
	}

	public void setNumeroOperacao(String numeroOperacao) {
		this.numeroOperacao = numeroOperacao;
	}

	public String getIdEmissor() {
		return idEmissor;
	}

	public void setIdEmissor(String idEmissor) {
		this.idEmissor = idEmissor;
	}

	public String getIdDestinatario() {
		return idDestinatario;
	}

	public void setIdDestinatario(String idDestinatario) {
		this.idDestinatario = idDestinatario;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public Optional<String> getIdContigencia() {
		return Optional.ofNullable(idContigencia);
	}

	public void setIdContigencia(String idContigencia) {
		this.idContigencia = idContigencia;
	}

	public Optional<String> getIdOperador() {
		return Optional.ofNullable(idOperador);
	}

	public void setIdOperador(String idOperador) {
		this.idOperador = idOperador;
	}

	public Optional<String> getIdOperadorConfirmacao() {
		return Optional.ofNullable(idOperadorConfirmacao);
	}

	public void setIdOperadorConfirmacao(String idOperadorConfirmacao) {
		this.idOperadorConfirmacao = idOperadorConfirmacao;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (numeroOperacao == null ? 0 : numeroOperacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Documento other = (Documento) obj;
		if (numeroOperacao == null) {
			if (other.numeroOperacao != null) {
				return false;
			}
		} else if (!numeroOperacao.equals(other.numeroOperacao)) {
			return false;
		}
		return true;
	}
}
