package com.mindty.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="nota")
public class Nota {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int nid;
	
	@ManyToOne ( fetch = FetchType.EAGER)
	@JoinColumn(name = "alumnoid")
	private Alumno usuario;
	
	@OneToOne
	private Modulo modulo;
	
	@Column
	private double nota;

	
	/* Constructores de Nota */

	public Nota() {
	}
	
	public Nota(Alumno usuario, Modulo modulo, double nota) {
		this.usuario = usuario;
		this.modulo = modulo;
		this.nota = nota;
	}

	public Nota(int nid, Alumno usuario, Modulo modulo, double nota) {
		super();
		this.nid = nid;
		this.usuario = usuario;
		this.modulo = modulo;
		this.nota = nota;
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public Alumno getUsuario() {
		return usuario;
	}

	public void setUsuario(Alumno usuario) {
		this.usuario = usuario;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
}
