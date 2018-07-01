package com.examen.agenda.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.examen.agenda.model.CatEmpresa;

public interface EmpresaRepository extends JpaRepository<CatEmpresa, Object> {
	
	@Query("from CatEmpresa where empresa like :query ")
	List<CatEmpresa> autocomplete(@Param("query")String query);

}