package com.examen.agenda.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@ApiModel
public class EmpresaDTO {

	@ApiModelProperty(position = 1, required = false, value = "Id Empresa")
	private Integer idEmpresa;

	@ApiModelProperty(position = 2, required = false, value = "Nombre de la empresa")
	private String empresa;

	@NotNull(message = "no puede ser nulo, valores válidos 1, 2 o 3")
	@ApiModelProperty(position = 3, required = true, value = "Rubro de la empresa")
	private String rubro;

	public EmpresaDTO() {
	}

	public EmpresaDTO(Integer idEmpresa, String empresa) {
		this.idEmpresa = idEmpresa;
		this.empresa = empresa;
	}

	public EmpresaDTO(Integer idEmpresa, String empresa, String rubro) {
		this.idEmpresa = idEmpresa;
		this.empresa = empresa;
		this.rubro = rubro;
	}

	public Integer getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getRubro() {
		return this.rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

}
