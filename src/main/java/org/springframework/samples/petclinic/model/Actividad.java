package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;


@Entity
@Table(name = "actividades")	
public class Actividad extends BaseEntity{

	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "opinion")
	@NotEmpty
	private String opinion;
	
	@Column(name = "valoracion")
	@Range(min=1,max=5)
	private Integer valoracion;
	
	@Column(name = "direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name = "precio")
	@NotEmpty
	@Digits(fraction = 0, integer = 8)
	private String precio;
	
	@ManyToOne
	@JoinColumn(name = "agenact_id")
	private AgenAct agenact;

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

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public AgenAct getAgenact() {
		return agenact;
	}

	public void setAgenact(AgenAct agenact) {
		this.agenact = agenact;
	}
}
