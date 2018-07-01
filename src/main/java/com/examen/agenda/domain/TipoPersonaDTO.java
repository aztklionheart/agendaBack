package com.examen.agenda.domain;

import io.swagger.annotations.ApiModel;


@ApiModel
public class TipoPersonaDTO {

	private Integer idTipoPersona;
	private String tipoPersona;

	public TipoPersonaDTO() {
	}

	public TipoPersonaDTO(Integer idTipoPersona, String tipoPersona) {
		this.idTipoPersona = idTipoPersona;
		this.tipoPersona = tipoPersona;
	}

	public Integer getIdTipoPersona() {
		return this.idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getTipoPersona() {
		return this.tipoPersona;
	}

	public void setTipoPersona(String tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

}
