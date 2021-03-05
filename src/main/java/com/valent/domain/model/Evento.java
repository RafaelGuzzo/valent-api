package com.valent.domain.model;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	private String Nome;

	@NotNull
	private OffsetDateTime data;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "evento")
	private List<Participante> participantes = new ArrayList<>();;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "eventos")
	private List<Fornecedor> fornecedores = new ArrayList<>();

	private String mensagemPadrao;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public OffsetDateTime getData() {
		return data;
	}

	public void setData(OffsetDateTime data) {
		this.data = data;
	}

	public List<Participante> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Participante> participantes) {
		this.participantes = participantes;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public String getMensagemPadrao() {
		return mensagemPadrao;
	}

	public void setMensagemPadrao(String mensagemPadrao) {
		this.mensagemPadrao = mensagemPadrao;
	}

}
