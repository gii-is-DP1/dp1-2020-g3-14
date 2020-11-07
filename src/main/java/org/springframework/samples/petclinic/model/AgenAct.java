package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Entity
@Table(name = "agenacts")
public class AgenAct extends BaseEntity {
	
	@Column(name = "nombre")
	private String nombre;

	@Column(name = "sede")
	private String sede;
	
	@Column(name = "telefono")
	private Integer telefono;
	
	/* PARA FINALIZAR
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "actividad", fetch = FetchType.EAGER)
	private Set<Visit> visits;
	*/

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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}	
}
