package com.examen.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.agenda.model.OPersona;

public interface PersonaRepository extends JpaRepository<OPersona, Object> {
	
	@Query("from OPersona where "
			+ "nombre like :query "
			+ "OR primerAp like :query "
			+ "OR segundoAp like :query")
	List<OPersona> autocomplete(@Param("query")String query);

}
