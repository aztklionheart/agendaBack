package com.examen.agenda.helper;

import com.examen.agenda.domain.PersonaDTO;
import com.examen.agenda.model.OPersona;

public class PersonaHelper {

	public static PersonaDTO pojoToDto (OPersona pojo){
		PersonaDTO dto = new PersonaDTO();
		dto.setDireccion(pojo.getDireccion());
		dto.setNombre(pojo.getNombre());
		dto.setPrimerAp(pojo.getPrimerAp());
		dto.setSegundoAp(pojo.getSegundoAp());
		dto.setIdPersona(pojo.getIdPersona());
		dto.setTelefono(pojo.getTelefono());
		dto.setIdTipoPersona(pojo.getCatTipoPersona().getIdTipoPersona());
		
		return dto;
		
	}
	
}
