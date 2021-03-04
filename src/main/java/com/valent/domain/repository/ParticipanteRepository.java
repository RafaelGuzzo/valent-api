package com.valent.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valent.domain.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

}
