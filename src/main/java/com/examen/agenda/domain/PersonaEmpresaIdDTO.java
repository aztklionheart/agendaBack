package com.examen.agenda.domain;
// Generated 18/06/2018 09:22:35 PM by Hibernate Tools 5.2.3.Final

import io.swagger.annotations.ApiModel;

@ApiModel
public class PersonaEmpresaIdDTO {

	private Integer idPersona;
	private Integer idEmpresa;

	public PersonaEmpresaIdDTO() {
	}

	public PersonaEmpresaIdDTO(Integer idPersona, Integer idEmpresa) {
		this.idPersona = idPersona;
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonaEmpresaIdDTO))
			return false;
		PersonaEmpresaIdDTO castOther = (PersonaEmpresaIdDTO) other;

		return (this.getIdPersona() == castOther.getIdPersona()) && (this.getIdEmpresa() == castOther.getIdEmpresa());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPersona();
		result = 37 * result + this.getIdEmpresa();
		return result;
	}

}
