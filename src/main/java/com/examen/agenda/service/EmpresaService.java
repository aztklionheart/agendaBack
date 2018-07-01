package com.examen.agenda.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.agenda.domain.EmpresaDTO;
import com.examen.agenda.model.CatEmpresa;
import com.examen.agenda.repository.EmpresaRepository;


@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public List<EmpresaDTO> autocompleteEmpresas(String query){
		
		ModelMapper modelMapper = new ModelMapper();
		
		List<CatEmpresa> lstCatEmpresa = empresaRepository.autocomplete("%"+query+"%");
		
		List<EmpresaDTO> lstEmpresaDTO = new ArrayList<>();
		
		for (CatEmpresa catEmpresa : lstCatEmpresa) {
			
			EmpresaDTO e = modelMapper.map(catEmpresa, EmpresaDTO.class);
			
			lstEmpresaDTO.add(e);
			
		}
		
		return lstEmpresaDTO;
	}
	
	
	public Integer addEmpresa( EmpresaDTO empresaDTO ) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		CatEmpresa catEmpresa = modelMapper.map(empresaDTO, CatEmpresa.class);
		
		return empresaRepository.save(catEmpresa).getIdEmpresa();
		
		
	}
}
