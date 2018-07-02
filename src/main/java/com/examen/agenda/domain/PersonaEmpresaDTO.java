package com.examen.agenda.domain;
// Generated 18/06/2018 09:22:35 PM by Hibernate Tools 5.2.3.Final


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PersonaEmpresaDTO {

	
	@ApiModelProperty(position = 2, required = false, value = "Area")
	private AreaDTO areaDTO;
	
	@ApiModelProperty(position = 3, required = false, value = "Empresa")
	private EmpresaDTO empresaDTO;
	
	@NotNull(message = "no puede ser nulo")
	@ApiModelProperty(position = 4, required = true, value = "Persona")
	private PersonaDTO personaDTO;

	public PersonaEmpresaDTO() {
	}

	public PersonaEmpresaDTO( AreaDTO catEmpresa, PersonaDTO personaDTO) {
		this.setEmpresaDTO(getEmpresaDTO());
		this.setPersonaDTO(personaDTO);
	}


	public AreaDTO getAreaDTO() {
		return areaDTO;
	}

	public void setAreaDTO(AreaDTO areaDTO) {
		this.areaDTO = areaDTO;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaDTO;
	}

	public void setEmpresaDTO(EmpresaDTO empresaDTO) {
		this.empresaDTO = empresaDTO;
	}

	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}

	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}
}