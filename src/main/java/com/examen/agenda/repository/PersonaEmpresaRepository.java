package com.examen.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.agenda.model.OPersonaEmpresa;

public interface PersonaEmpresaRepository extends JpaRepository<OPersonaEmpresa, Object> {
	
	OPersonaEmpresa findByIdIdPersona(Integer idPersona);

}
