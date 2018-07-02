package com.examen.agenda.helper;

import java.util.ArrayList;
import java.util.List;

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
			dto.setEmpresaDTO(pojoToDto(pojoPersonaEmpresa.getCatEmpresa()));
			if(pojoPersonaEmpresa.getCatArea()!=null){
				dto.setAreaDTO(pojoToDto(pojoPersonaEmpresa.getCatArea()));
				
			}
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
	
	public static List<PersonaEmpresaDTO> pojoToDtoList(List<OPersona> listPersona, List<OPersonaEmpresa> listPersonaEmpresa){
		List<PersonaEmpresaDTO> listDto = new ArrayList<>();
		if(listPersonaEmpresa!=null && !listPersonaEmpresa.isEmpty()){
			for (OPersonaEmpresa oPersona : listPersonaEmpresa) {
				listDto.add(pojoToDto(pojoToDto(oPersona.getOPersona()),oPersona));
			}
		}else{
			for (OPersona oPersona : listPersona) {
				listDto.add(pojoToDto(pojoToDto(oPersona),null));
			}
			
		}
		
		return listDto;
	}
}
