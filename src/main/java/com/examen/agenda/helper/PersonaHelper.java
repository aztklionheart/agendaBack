package com.examen.agenda.helper;

import com.examen.agenda.domain.AreaDTO;
import com.examen.agenda.domain.EmpresaDTO;
import com.examen.agenda.domain.PersonaDTO;
import com.examen.agenda.domain.PersonaEmpresaDTO;
import com.examen.agenda.model.CatArea;
import com.examen.agenda.model.CatEmpresa;
import com.examen.agenda.model.OPersona;
import com.examen.agenda.model.OPersonaEmpresa;

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
	
	public static PersonaEmpresaDTO pojoToDto(PersonaDTO dtoPersona, OPersonaEmpresa pojoPersonaEmpresa){
		PersonaEmpresaDTO dto = new PersonaEmpresaDTO();
		if(pojoPersonaEmpresa!=null){
			dto.setAreaDTO(pojoToDto(pojoPersonaEmpresa.getCatArea()));
			dto.setEmpresaDTO(pojoToDto(pojoPersonaEmpresa.getCatEmpresa()));
		}
		dto.setPersonaDTO(dtoPersona);
		return dto;
	}
	
	
	public static EmpresaDTO pojoToDto(CatEmpresa pojo){
		EmpresaDTO dto = new EmpresaDTO();
		dto.setEmpresa(pojo.getEmpresa());
		dto.setIdEmpresa(pojo.getIdEmpresa());
		dto.setRubro(pojo.getRubro());
		
		return dto;
		
	}
	public static AreaDTO pojoToDto(CatArea pojo){
		AreaDTO dto = new AreaDTO();
		dto.setIdArea(pojo.getIdArea());
		dto.setNombreArea(pojo.getNombreArea());
		
		return dto;
	}
}
