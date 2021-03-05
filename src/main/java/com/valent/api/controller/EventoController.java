package com.valent.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valent.domain.model.Evento;
import com.valent.domain.model.Fornecedor;
import com.valent.domain.model.Participante;
import com.valent.domain.repository.EventoRepository;
import com.valent.domain.service.GestaoParticipanteEventoService;

@RestController
@RequestMapping("/eventos")
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private GestaoParticipanteEventoService gestaoEvento;

	@PostMapping
	public Evento adicionar(@RequestBody Evento evento) {
		return eventoRepository.save(evento);
	}

	@PostMapping("/{idEvento}/participantes")
	public Evento adicionarParticipante(@PathVariable Long idEvento, @Valid @RequestBody Participante participante) {
		return gestaoEvento.adicionarParticipanteEvento(idEvento, participante);
	}

	@DeleteMapping("/{idEvento}/participantes/{idParticipante}")
	public void removerParticipante(@PathVariable Long idEvento, @PathVariable Long idParticipante) {
		gestaoEvento.removerParticipanteEvento(idEvento, idParticipante);
	}

	@PutMapping("/{idEvento}/fornecedores")
	public Evento adicionarFornecedor(@PathVariable Long idEvento, @RequestBody Fornecedor fornecedor) {
		return gestaoEvento.adicionarFornecedorEvento(idEvento, fornecedor.getIdPessoa());
	}
}
