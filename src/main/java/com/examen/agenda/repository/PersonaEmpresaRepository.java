package com.examen.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.agenda.model.OPersonaEmpresa;



public interface PersonaEmpresaRepository extends JpaRepository<OPersonaEmpresa, Object> {
	
	OPersonaEmpresa findByIdIdPersona(Integer idPersona);
	
	@Query("from OPersonaEmpresa pe where pe.OPersona.catTipoPersona.idTipoPersona=:idTipo")
	List<OPersonaEmpresa> findByIdTipoPersona(@Param("idTipo") Integer idTipo);

}
