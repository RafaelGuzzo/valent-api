package com.valent.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valent.domain.model.Evento;
import com.valent.domain.repository.EventoRepository;

@RestController
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;

	@RequestMapping
	public Evento adicionar(@RequestBody Evento evento) {
		return eventoRepository.save(evento);
	}
}
