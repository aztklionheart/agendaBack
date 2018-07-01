package com.examen.agenda.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.agenda.domain.AreaDTO;
import com.examen.agenda.model.CatArea;
import com.examen.agenda.repository.AreaRepository;

@Service
public class AreaService {

	@Autowired
	private AreaRepository areaRepository;
	
	public Integer addArea(AreaDTO areaDTO) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		CatArea catArea = modelMapper.map(areaDTO, CatArea.class);
		CatArea catArea2 = areaRepository.save(catArea);
		
		return catArea2.getIdArea();
	}
	
}
