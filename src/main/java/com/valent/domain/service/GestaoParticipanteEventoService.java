package com.valent.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valent.domain.model.Evento;
import com.valent.domain.model.Fornecedor;
import com.valent.domain.model.Participante;
import com.valent.domain.repository.EventoRepository;
import com.valent.domain.repository.FornecedorRepository;
import com.valent.domain.repository.ParticipanteRepository;

@Service
public class GestaoParticipanteEventoService {

	@Autowired
	private ParticipanteRepository participanteRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private EventoRepository eventoRepository;

	public Evento adicionarParticipanteEvento(Long idEvento, Participante participante) {
		Evento evento = eventoRepository.findById(idEvento).orElse(null);
		// TODO alterar para classe que trata execeções
		participante.setEvento(evento);
		return participanteRepository.save(participante).getEvento();
	}

	public void removerParticipanteEvento(Long idEvento, Long idParticipante) {
		//Evento evento = eventoRepository.findById(idEvento).orElse(null);
		participanteRepository.deleteById(idParticipante);
	}

	public Evento adicionarFornecedorEvento(Long idEvento, Long idFornecedor) {
		Evento evento = eventoRepository.findById(idEvento).orElse(null);
		Fornecedor fornecedor = fornecedorRepository.findById(idFornecedor).orElse(null);
		// TODO alterar para classe que trata execeções
		fornecedor.addEvento(evento);
		fornecedorRepository.save(fornecedor);
		return evento;
	}

}
