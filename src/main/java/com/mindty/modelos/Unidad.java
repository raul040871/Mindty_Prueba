package com.mindty.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unidad")
public class Unidad {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUni;
	
	@Column
	private String nombreUnidad;
	
	
	/* Constructores de Unidad */
	
	public Unidad() {
	}
	
	public Unidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
	
	public Unidad(int idUni, String nombreUnidad) {
		this.idUni = idUni;
		this.nombreUnidad = nombreUnidad;
	}
	
	
	/* Geters & Seters de Unidad */
	
	public int getIdUni() {
		return idUni;
	}
	
	public void setIdUni(int idUni) {
		this.idUni = idUni;
	}
	
	public String getNombreUnidad() {
		return nombreUnidad;
	}
	
	public void setNombreUnidad(String nombreUnidad) {
		this.nombreUnidad = nombreUnidad;
	}
}