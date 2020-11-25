package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

@Entity
@Table(name = "actividades")
public class Actividad extends BaseEntity {
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "valoracion")
	private Integer valoracion;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "precio")
	private Integer precio;
	
	@ManyToOne
	@JoinColumn(name = "agenact_id")
	private AgenAct agenciaActividades;
	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getOpinion() {
		return opinion;
	}


	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}


	public Integer getValoracion() {
		return valoracion;
	}


	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public Integer getPrecio() {
		return precio;
	}


	public void setPrecio(Integer precio) {
		this.precio = precio;
	}


	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("nombre", this.getNombre())
				.append("opinion", this.opinion).append("valoracion", this.valoracion).append("direccion", this.direccion)
				.append("precio", this.precio).toString();
	}
}
