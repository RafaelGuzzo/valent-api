package com.valent.api.model;

import java.util.ArrayList;
import java.util.List;

public class FornecedorModel {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cnpj;
	private List<EventoResumoModel> eventos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<EventoResumoModel> getEventos() {
		return eventos;
	}

	public void setEventos(List<EventoResumoModel> eventos) {
		this.eventos = eventos;
	}

}
