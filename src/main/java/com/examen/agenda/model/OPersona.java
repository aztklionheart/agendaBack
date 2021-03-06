package com.examen.agenda.model;
// Generated 18/06/2018 09:22:35 PM by Hibernate Tools 5.2.3.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OPersona generated by hbm2java
 */
@Entity
@Table(name = "o_persona", catalog = "agenda")
public class OPersona implements java.io.Serializable {

	private Integer idPersona;
	private CatTipoPersona catTipoPersona;
	private String nombre;
	private String primerAp;
	private String segundoAp;
	private String direccion;
	private String telefono;
	private Set<OPersonaEmpresa> OPersonaEmpresas = new HashSet<OPersonaEmpresa>(0);

	public OPersona() {
	}

	public OPersona(Integer idPersona, CatTipoPersona catTipoPersona, String nombre, String primerAp, String segundoAp,
			String telefono) {
		this.idPersona = idPersona;
		this.catTipoPersona = catTipoPersona;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.telefono = telefono;
	}

	public OPersona(Integer idPersona, CatTipoPersona catTipoPersona, String nombre, String primerAp, String segundoAp,
			String direccion, String telefono, Set<OPersonaEmpresa> OPersonaEmpresas) {
		this.idPersona = idPersona;
		this.catTipoPersona = catTipoPersona;
		this.nombre = nombre;
		this.primerAp = primerAp;
		this.segundoAp = segundoAp;
		this.direccion = direccion;
		this.telefono = telefono;
		this.OPersonaEmpresas = OPersonaEmpresas;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_persona", unique = true, nullable = false)
	public Integer getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cat_tipo_persona", nullable = false)
	public CatTipoPersona getCatTipoPersona() {
		return this.catTipoPersona;
	}

	public void setCatTipoPersona(CatTipoPersona catTipoPersona) {
		this.catTipoPersona = catTipoPersona;
	}

	@Column(name = "nombre", nullable = false, length = 45)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "primer_ap", nullable = false, length = 45)
	public String getPrimerAp() {
		return this.primerAp;
	}

	public void setPrimerAp(String primerAp) {
		this.primerAp = primerAp;
	}

	@Column(name = "segundo_ap", nullable = false, length = 45)
	public String getSegundoAp() {
		return this.segundoAp;
	}

	public void setSegundoAp(String segundoAp) {
		this.segundoAp = segundoAp;
	}

	@Column(name = "direccion", length = 245)
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Column(name = "telefono", nullable = false, length = 10)
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "OPersona")
	public Set<OPersonaEmpresa> getOPersonaEmpresas() {
		return this.OPersonaEmpresas;
	}

	public void setOPersonaEmpresas(Set<OPersonaEmpresa> OPersonaEmpresas) {
		this.OPersonaEmpresas = OPersonaEmpresas;
	}

}
