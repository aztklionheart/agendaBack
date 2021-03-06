package com.examen.agenda.model;
// Generated 18/06/2018 09:22:35 PM by Hibernate Tools 5.2.3.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * OPersonaEmpresa generated by hbm2java
 */
@Entity
@Table(name = "o_persona_empresa", catalog = "agenda")
public class OPersonaEmpresa implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3501297376038955729L;
	
	private OPersonaEmpresaId id;
	private CatArea catArea;
	private CatEmpresa catEmpresa;
	private OPersona OPersona;

	public OPersonaEmpresa() {
	}

	public OPersonaEmpresa(OPersonaEmpresaId id, CatEmpresa catEmpresa, OPersona OPersona) {
		this.id = id;
		this.catEmpresa = catEmpresa;
		this.OPersona = OPersona;
	}

	public OPersonaEmpresa(OPersonaEmpresaId id, CatArea catArea, CatEmpresa catEmpresa, OPersona OPersona) {
		this.id = id;
		this.catArea = catArea;
		this.catEmpresa = catEmpresa;
		this.OPersona = OPersona;
	}

	@EmbeddedId
	@GeneratedValue(strategy = GenerationType.AUTO)
	@AttributeOverrides({
			@AttributeOverride(name = "idPersona", column = @Column(name = "id_persona", nullable = false)),
			@AttributeOverride(name = "idEmpresa", column = @Column(name = "id_empresa", nullable = false)) })
	public OPersonaEmpresaId getId() {
		return this.id;
	}

	public void setId(OPersonaEmpresaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_area")
	public CatArea getCatArea() {
		return this.catArea;
	}

	public void setCatArea(CatArea catArea) {
		this.catArea = catArea;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false, insertable = false, updatable = false)
	public CatEmpresa getCatEmpresa() {
		return this.catEmpresa;
	}

	public void setCatEmpresa(CatEmpresa catEmpresa) {
		this.catEmpresa = catEmpresa;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false, insertable = false, updatable = false)
	public OPersona getOPersona() {
		return this.OPersona;
	}

	public void setOPersona(OPersona OPersona) {
		this.OPersona = OPersona;
	}

}