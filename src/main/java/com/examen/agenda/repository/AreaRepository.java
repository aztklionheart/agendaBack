package com.examen.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.agenda.model.CatArea;

public interface AreaRepository extends JpaRepository<CatArea, Object> {

}
