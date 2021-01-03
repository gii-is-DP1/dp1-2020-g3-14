package org.springframework.samples.petclinic.model;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservasHotel")

public class ReservaHotel extends BaseEntity{
	

		
		//Atributos clase
		
		@Column(name = "fecha")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		@Future
		private LocalDate fecha;
		
		@Column(name = "numeroTarjeta")
		@NotEmpty
		private Integer numeroTarjeta;
		
		@Column(name = "cvc")
		@NotEmpty
		private Integer cvc;
		
		//Atributo otras clases 
		@ManyToOne
		@JoinColumn(name = "username")
		private User user;
		
		@ManyToOne
		@JoinColumn(name = "hotel")
		private Hotel hotel;
		
		@ManyToOne
		@JoinColumn(name = "habitacion")
		private Habitacion habitacion;

			
		//Getters y setters todos los atributos
		
		
		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
			
		public Integer getNumeroTarjeta() {
			return numeroTarjeta;
		}

		public void setNumeroTarjeta(Integer numTarjeta) {
			this.numeroTarjeta = numTarjeta;
		}
		
		public Integer getCvc() {
			return cvc;
		}

		public void setCvc(Integer cvc) {
			this.cvc = cvc;
		}
		
				//Parametro Usuario
		public User getUser() {
			return this.user;
		}

		protected void setUser(User user) {
			this.user = user;
		}	
				//Parametro Hotel
		public Hotel getHotel() {
			return hotel;
		}
		
		public void setHotel(Hotel hotelito) {
			this.hotel = hotelito;
		}
		
			//Parametro Habitacion
		
		public Habitacion getHabitacion() {
			return habitacion;
		}

		public void setHabitacion(Habitacion habitacion) {
			this.habitacion = habitacion;
		}	
		
		
		
}
