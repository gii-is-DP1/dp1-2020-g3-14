package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;

import com.sun.istack.NotNull;

@Entity
@Table(name = "Comentarios")
public class Comentario extends BaseEntity{
	
	@Column(name = "puntuacion")
	@NotNull
	@Range(min=1,max=10)
	private Integer puntuacion;
	
	@Column(name = "mensaje")
	@NotEmpty
	private String mensaje;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
