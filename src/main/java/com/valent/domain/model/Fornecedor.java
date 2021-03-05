package com.valent.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@PrimaryKeyJoinColumn(name = "idPessoa")
public class Fornecedor extends Pessoa {

	private String cnpj;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name ="fornecedor_evento", 
	joinColumns = @JoinColumn(name = "fornecedor_id"), 
	inverseJoinColumns = @JoinColumn(name = "evento_id"))
	private List<Evento> eventos;

	public List<Evento> getEventos() {
		return eventos;
	}

	public void addEvento(Evento evento) {
		this.eventos.add(evento);
		evento.getFornecedores().add(this);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
