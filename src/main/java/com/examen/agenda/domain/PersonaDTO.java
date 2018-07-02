package com.examen.agenda.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@ApiModel
public class PersonaDTO {

	@ApiModelProperty(position = 1, required = false, value = "Id Persona")
	private Integer idPersona;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 2, required = true, value = "Id Tipo de persona")
	private  Integer idTipoPersona;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 3, required = true, value = "Nombre de la persona")
	private String nombre;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 4, required = true, value = "Primer apellido de la persona")
	private String primerAp;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 5, required = true, value = "Segundo apellido de la persona")
	private String segundoAp;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 6, required = true, value = "Dirección de la persona")
	private String direccion;

	@NotNull(message = "no puede ser null")
	@ApiModelProperty(position = 7, required = true, value = "Telefono")
	@Pattern(regexp = "^[0-9]{10}$", message = "de ser {regexp}")
	private String telefono;


	public PersonaDTO() {
	}

	public PersonaDTO(Integer idPersona, Integer idTipoPersona, String nombre, String primerAp, String segundoAp,
                      String telefono) {
		this.idPersona = idPersona;
		this.idTipoPersona = idTipoPersona;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.telefono = telefono;
	}

	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	
	public Integer getIdTipoPersona() {
		return idTipoPersona;
	}

	public void setIdTipoPersona(Integer idTipoPersona) {
		this.idTipoPersona = idTipoPersona;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrimerAp() {
		return this.primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	public String getSegundoAp() {
		return this.segundoAp;
	}

	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}