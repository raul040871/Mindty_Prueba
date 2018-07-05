package com.mindty.modelos;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Alumno extends Usuario {
	
	@OneToMany(mappedBy="usuario", cascade=CascadeType.ALL)
	private List<Nota> listaNota;

	public Alumno() {
		super();
	}

	public Alumno(List<Nota> listaNota) {
		super();
		this.listaNota = listaNota;
	}

	public List<Nota> getListaNota() {
		return listaNota;
	}

	public void setListaNota(List<Nota> listaNota) {
		this.listaNota = listaNota;
	}
}