package com.valent.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valent.domain.model.Participante;
import com.valent.domain.repository.ParticipanteRepository;

@RestController
@RequestMapping("/participantes")
public class ParticipanteController {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@PostMapping
	public Participante adicionar(@RequestBody Participante participante) {
		return participanteRepository.save(participante);
	}
}
