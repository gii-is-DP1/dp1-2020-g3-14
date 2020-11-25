package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;


@Entity
@Table(name = "agenacts")
public class AgenAct extends BaseEntity {
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "sede")
	@NotEmpty
	private String sede;
	
	@Column(name = "telefono")
	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telefono;
	
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSede() {
		return this.sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}	
	
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("nombre", this.getNombre())
				.append("sede", this.sede).append("telefono", this.telefono).toString();
	}
}
