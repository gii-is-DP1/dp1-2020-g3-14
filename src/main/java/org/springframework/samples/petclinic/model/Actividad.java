package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "actividades")	
public class Actividad {

	@Id
	@NotEmpty
	private Integer id;
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "opinion")
	private String opinion;
	
	@Column(name = "valoracion")
	@Range(min=1,max=5)
	private Integer valoracion;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "precio")
	private Integer precio;
	
	@ManyToOne
	@JoinColumn(name = "agenact_id")
	private AgenAct agenact;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public AgenAct getAgenact() {
		return agenact;
	}

	public void setAgenact(AgenAct agenact) {
		this.agenact = agenact;
	}
		
}
