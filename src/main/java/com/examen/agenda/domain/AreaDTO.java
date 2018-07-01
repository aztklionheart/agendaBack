package com.examen.agenda.domain;
// Generated 18/06/2018 09:22:35 PM by Hibernate Tools 5.2.3.Final

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AreaDTO implements java.io.Serializable {

	@ApiModelProperty(position = 1, required = false, value = "Id Area")
	private Integer idArea;
	@ApiModelProperty(position = 2, required = true, value = "Area de la empresa")
	private String nombreArea;

	public AreaDTO() {
	}

	public AreaDTO(Integer idArea, String nombreArea) {
		this.idArea = idArea;
		this.nombreArea = nombreArea;
	}

	public Integer getIdArea() {
		return this.idArea;
	}

	public void setIdArea(Integer idArea) {
		this.idArea = idArea;
	}

	public String getNombreArea() {
		return this.nombreArea;
	}

	public void setNombreArea(String nombreArea) {
		this.nombreArea = nombreArea;
	}

}