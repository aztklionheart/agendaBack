package com.examen.agenda.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.agenda.domain.PersonaEmpresaDTO;
import com.examen.agenda.model.CatArea;
import com.examen.agenda.model.CatEmpresa;
import com.examen.agenda.model.OPersona;
import com.examen.agenda.model.OPersonaEmpresa;
import com.examen.agenda.model.OPersonaEmpresaId;
import com.examen.agenda.repository.PersonaEmpresaRepository;
import com.examen.agenda.repository.PersonaRepository;

@Service
public class PersonaEmpresaService {

	@Autowired
	private PersonaEmpresaRepository personaEmpresaRepository;
	
	@Autowired
	private PersonaService personaService;
	
	@Autowired
	private EmpresaService empresaService;
	
	@Autowired
	private AreaService areaService;
	
	
	public void add( PersonaEmpresaDTO personaEmpresaDTO ){
		
		ModelMapper modelMapper = new ModelMapper();
		
		OPersonaEmpresa oPersonaEmpresa = modelMapper.map(personaEmpresaDTO, OPersonaEmpresa.class);
		
		oPersonaEmpresa.setCatArea(modelMapper.map(personaEmpresaDTO.getAreaDTO(), CatArea.class));
		oPersonaEmpresa.setCatEmpresa(modelMapper.map(personaEmpresaDTO.getEmpresaDTO(), CatEmpresa.class));
		oPersonaEmpresa.setOPersona(modelMapper.map(personaEmpresaDTO.getPersonaDTO(), OPersona.class));
		
		Integer idPersona = personaService.addPersona(personaEmpresaDTO.getPersonaDTO());
		
		if(null != personaEmpresaDTO.getEmpresaDTO()) {//la empresa tiene que guardarse
			
			Integer idArea = null;
			Integer idEmpresa = null;
			
			if(null == personaEmpresaDTO.getEmpresaDTO().getIdEmpresa()) { //la empresa no existe
				
				idArea = areaService.addArea(personaEmpresaDTO.getAreaDTO());
				
				idEmpresa = empresaService.addEmpresa(personaEmpresaDTO.getEmpresaDTO());
				
				oPersonaEmpresa.getCatArea().setIdArea(idArea);
				oPersonaEmpresa.getCatEmpresa().setIdEmpresa(idEmpresa);
			}
			
			oPersonaEmpresa.getOPersona().setIdPersona(idPersona);
			
			oPersonaEmpresa.setId(new OPersonaEmpresaId(idPersona,idEmpresa));
			
			personaEmpresaRepository.save(oPersonaEmpresa);
		}
		
	}
	
	
	
	public List<PersonaEmpresaDTO> findAll(){
		
		ModelMapper modelMapper = new ModelMapper();
		
		List<PersonaEmpresaDTO> lstPersonaEmpresaDTO = new ArrayList<>();
		
		List<OPersonaEmpresa> lstOPersonaEmpresa = personaEmpresaRepository.findAll();
		
		for (OPersonaEmpresa oPersonaEmpresa : lstOPersonaEmpresa) {
		
			PersonaEmpresaDTO personaEmpresaDTO = modelMapper.map(oPersonaEmpresa, PersonaEmpresaDTO.class);
			
			lstPersonaEmpresaDTO.add(personaEmpresaDTO);
			
		}
		
		return lstPersonaEmpresaDTO;
		
		
	}
	
}
