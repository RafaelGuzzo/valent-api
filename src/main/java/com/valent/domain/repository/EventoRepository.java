package com.valent.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valent.domain.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
