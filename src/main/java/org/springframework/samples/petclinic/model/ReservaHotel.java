package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
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
		@Digits(fraction = 0, integer = 16)
		private String numeroTarjeta;
		
		@Id
		@Column(name = "cvc")
		@NotEmpty
		private Integer cvc;
		
		
		
		//Atributo otras clases 
		
		@ManyToOne
		@JoinColumn(name = "username")
		private User user;
		
		
		@ManyToOne
		@JoinColumn(name = "hotel_id")
		private Hotel hotel;
		
		
		@OneToMany(cascade = CascadeType.ALL, mappedBy = "reservaHotel")
		private Set<Habitacion> habitaciones;
		
			
		//Getters y setters todos los atributos
		
		
		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}
			
		public String getNumeroTarjeta() {
			return numeroTarjeta;
		}

		public void setNumeroTarjeta(String numTarjeta) {
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

		public void setUser(User user) {
			this.user = user;
		}	
		
				//Parametro Hotel
		
		public Hotel getHotel() {
			return hotel;
		}
		
		public void setHotel(Hotel hotelito) {
			this.hotel = hotelito;
		}
		
			//Parametro Habitaciones
		
		public Set<Habitacion> getHabitaciones() {
			return habitaciones;
		}

		public void setHabitaciones(Set<Habitacion> habitaciones) {
			this.habitaciones = habitaciones;
		}	
		
		
		
}
