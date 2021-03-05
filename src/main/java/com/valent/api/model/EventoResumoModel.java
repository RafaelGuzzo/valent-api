package com.valent.api.model;

import java.time.OffsetDateTime;

public class EventoResumoModel {
	private Long id;
	private String nome;
	private OffsetDateTime dataEvento;

	public EventoResumoModel() {

	}

	public EventoResumoModel(Long id, String nome, OffsetDateTime dataEvento) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataEvento = dataEvento;
	}

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

	public OffsetDateTime getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(OffsetDateTime dataEvento) {
		this.dataEvento = dataEvento;
	}

}
