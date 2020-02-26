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
@Table(schema = "api", name = "instituicoes")
@SequenceGenerator(schema = "api", name = "id_instituicoes_seq", sequenceName = "id_instituicoes_seq")
public class Instituicoes {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_instituicoes_seq")
	private Long id;

	@Column(name = "cnpj", nullable = false, unique = true, length = 14)
	private String cnpj;

	@Column(name = "nome", nullable = false, unique = true, length = 150)
	private String nome;

	public Optional<Long> getId() {
		return Optional.ofNullable(id);
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
