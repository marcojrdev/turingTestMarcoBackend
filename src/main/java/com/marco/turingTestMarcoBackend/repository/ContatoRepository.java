package com.marco.turingTestMarcoBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marco.turingTestMarcoBackend.models.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{
	
	Contato findById(long id);
}
