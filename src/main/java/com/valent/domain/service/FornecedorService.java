package com.valent.domain.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valent.api.model.EventoResumoModel;
import com.valent.api.model.FornecedorModel;
import com.valent.domain.exception.EntidadeNaoEncontradaException;
import com.valent.domain.model.Evento;
import com.valent.domain.model.Fornecedor;
import com.valent.domain.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public FornecedorModel buscarPorId(Long id) {
		Fornecedor fornecedor = fornecedorRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado!"));

		return toModel(fornecedor);
	}

	public List<FornecedorModel> buscarTodos() {
		return fornecedorRepository.findAll()
				.stream()
				.map(fornecedor -> toModel(fornecedor))
				.collect(Collectors.toList());
	}

	private FornecedorModel toModel(Fornecedor fornecedor) {

		var eventos = toListEventoResumoModel(fornecedor.getEventos());
		var fornecedorModel = new FornecedorModel();

		fornecedorModel.setId(fornecedor.getIdPessoa());
		fornecedorModel.setNome(fornecedor.getNome());
		fornecedorModel.setEmail(fornecedor.getEmail());
		fornecedorModel.setTelefone(fornecedor.getTelefone());
		fornecedorModel.setCnpj(fornecedor.getCnpj());
		fornecedorModel.setEventos(eventos);

		return fornecedorModel;
	}

	private EventoResumoModel toModelEvento(Evento evento) {
		return new EventoResumoModel(evento.getId(), evento.getNome(), evento.getData());

	}

	private List<EventoResumoModel> toListEventoResumoModel(List<Evento> eventos) {
		return eventos
				.stream()
				.map(evento -> toModelEvento(evento))
				.collect(Collectors.toList());
	}

}
