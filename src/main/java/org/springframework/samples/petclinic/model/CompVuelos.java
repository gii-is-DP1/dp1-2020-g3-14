package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "compvuelos")
public class CompVuelos extends BaseEntity {
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "sede")
	@NotEmpty
	private String sede;
	
	@Column(name = "pais")
	@NotEmpty
	private String pais;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "CompVuelos [nombre=" + nombre + ", sede=" + sede + ", pais=" + pais + "]";
	}
	
	
	
}
