package com.mindty.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idm;

	@Column
	private String nombreModulo;

	@ManyToMany(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.PERSIST
    }, fetch = FetchType.EAGER)
	@JoinTable(name = "modulo_unidad", joinColumns = { @JoinColumn(name = "idModulo") }, inverseJoinColumns = {
			@JoinColumn(name = "idUnidad") })
	private List<Unidad> unidad;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "modulo")
	private Nota nota;

	public Modulo() {
		super();
	}
	
	public Modulo(String nombreModulo, List<Unidad> unidad) {
		super();
		this.nombreModulo = nombreModulo;
		this.unidad = unidad;
	}

	public Modulo(int idm, String nombreModulo, List<Unidad> unidad) {
		super();
		this.idm = idm;
		this.nombreModulo = nombreModulo;
		this.unidad = unidad;
	}

	public int getIdm() {
		return idm;
	}

	public void setIdm(int idm) {
		this.idm = idm;
	}

	public String getNombreModulo() {
		return nombreModulo;
	}

	public void setNombreModulo(String nombreModulo) {
		this.nombreModulo = nombreModulo;
	}

	public List<Unidad> getUnidad() {
		return unidad;
	}

	public void setUnidad(List<Unidad> unidad) {
		this.unidad = unidad;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}