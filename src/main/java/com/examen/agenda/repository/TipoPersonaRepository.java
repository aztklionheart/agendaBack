package com.examen.agenda.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.agenda.domain.TipoPersonaDTO;
import com.examen.agenda.model.CatTipoPersona;

public interface TipoPersonaRepository extends JpaRepository<CatTipoPersona, Object> {
	
	@Query("from CatTipoPersona where tipoPersona like :tipo ")
	List<CatTipoPersona> findByNameComplete(@Param("tipo") String tipo );
	
	
	@Query("SELECT new com.examen.agenda.domain.TipoPersonaDTO("
			+ "idTipoPersona, tipoPersona"
			+ ") from CatTipoPersona")
	List<TipoPersonaDTO> findAllDto();
	
}