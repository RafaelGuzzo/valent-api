package com.valent.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valent.domain.model.Evento;
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
	public Evento adicionarParticipante(@PathVariable Long idEvento, @RequestBody Participante participante) {
		return gestaoEvento.adicionarParticipanteEvento(idEvento, participante);
	}
}
