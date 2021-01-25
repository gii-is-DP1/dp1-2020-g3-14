package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservasvuelo")
public class ReservaVuelo extends BaseEntity {
	
	
	@Column(name = "fechareserva")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaReserva;					//Es por defecto la fecha del sistema en el momento de realizar la reserva
	
	@Column(name = "fechaida")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@FutureOrPresent
    @NotNull
	private LocalDate ida;							//Es por defecto la fecha en la que sale el vuelo (Parametro de vuelo)
	
	@Column(name = "fechavuelta")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Future
    @NotNull
	private LocalDate vuelta;                      	// No tiene sentido a no ser que escojas un vuelo de vuelta
	
	@Column(name = "numeroTarjeta")
	@Pattern(regexp="\\d{16}")
	private String numeroTarjeta;					//Se introduce al realizar la reserva
	
	@Column(name = "cvc")
	@Pattern(regexp="\\d{3}")
	private String cvc;								//Se introduce al realizar la reserva
	
	@Column(name="precio")
	private Integer precio;						    //Es por defecto el precio del vuelo (Parametro de vuelo)
	
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;								//Es por defecto el usuario que realiza la reserva 
	
	@OneToOne
	@JoinColumn(name = "vuelo_id")
	private Vuelo vuelo;							//Es por defecto el id_Vuelo del Vuelo reservado
	
	
	
	
	
	
	
	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precioFinal) {
		this.precio = precioFinal;
	}

	public LocalDate getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	
	public LocalDate getFechaIda() {
		return ida;
	}

	public void setFechaIda(LocalDate ida) {
		this.ida = ida;
	}

	public LocalDate getFechaVuelta() {
		return vuelta;
	}

	public void setFechaVuelta(LocalDate vuelta) {
		this.vuelta = vuelta;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numTarjeta) {
		this.numeroTarjeta = numTarjeta;
	}
	
	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}


	
}
