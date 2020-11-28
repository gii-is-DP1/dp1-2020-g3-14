package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Entity
@Table(name = "habitaciones")
public class Habitacion{
	
	@Id
	
	Integer nhabitacion;
	
	@Column(name = "ncamas")
	
	private Integer ncamas;
	
	@Column(name = "precio")
	
	private Integer precio;
	
	@Column(name = "disponible")
	
	private Boolean disponible;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getNhabitacion() {
		return nhabitacion;
	}

	public void setNhabitacion(Integer nhabitacion) {
		this.nhabitacion = nhabitacion;
	}

	public Integer getNcamas() {
		return ncamas;
	}

	public void setNcamas(Integer ncamas) {
		this.ncamas = ncamas;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	

}
