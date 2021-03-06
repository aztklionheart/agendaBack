package com.examen.agenda.service;


import com.examen.agenda.domain.TipoPersonaDTO;
import com.examen.agenda.model.CatTipoPersona;
import com.examen.agenda.repository.TipoPersonaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoPersonaService {

	@Autowired
	private TipoPersonaRepository tipoPersonaRepository;

    public List<TipoPersonaDTO> getTiposPersona(){
    	
    	List<TipoPersonaDTO> lstCatTipoPersona = tipoPersonaRepository.findAllDto();
    	

        return lstCatTipoPersona;
    }

public Integer getPrueba(){
    	
    	Integer uno = (int) tipoPersonaRepository.count();
    	
    	System.out.println("***************************" + uno);

        return uno;
    }
}
