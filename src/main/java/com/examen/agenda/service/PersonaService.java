package com.examen.agenda.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.agenda.domain.PersonaDTO;
import com.examen.agenda.helper.PersonaHelper;
import com.examen.agenda.model.OPersona;
import com.examen.agenda.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	public List<PersonaDTO> autocomplete(String query) {

		ModelMapper modelMapper = new ModelMapper();
		List<PersonaDTO> lstPersonaDTO = new ArrayList();

		List<OPersona> lstPersona = personaRepository.autocomplete("%" + query + "%");

		for (OPersona oPersona : lstPersona) {

			PersonaDTO personaDTO = modelMapper.map(oPersona, PersonaDTO.class);

			lstPersonaDTO.add(personaDTO);

		}

		return lstPersonaDTO;

	}

	public PersonaDTO findById(Integer id) {

		Optional<OPersona> persona = personaRepository.findById(id);

		PersonaDTO personaDTO = PersonaHelper.pojoToDto(persona.get());

		return personaDTO;

	}

	public Integer addPersona(PersonaDTO personaDTO) {

		ModelMapper modelMapper = new ModelMapper();

		OPersona oPersona = modelMapper.map(personaDTO, OPersona.class);

		OPersona oPersona2 = personaRepository.save(oPersona);

		return (int) oPersona2.getIdPersona();

	}

	public void deletePersona(Integer idPersona) {

		personaRepository.deleteById(idPersona);

	}

	public Integer updatePersona(PersonaDTO personaDTO) {

		ModelMapper modelMapper = new ModelMapper();

		OPersona oPersona = modelMapper.map(personaDTO, OPersona.class);

		OPersona oPersona2 = personaRepository.save(oPersona);

		return (int) oPersona2.getIdPersona();

	}

}
