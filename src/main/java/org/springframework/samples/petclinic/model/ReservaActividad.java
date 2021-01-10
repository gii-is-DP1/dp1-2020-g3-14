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
@Table(name="reservasActividad")

public class ReservaActividad extends BaseEntity {	

		
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
		@JoinColumn(name = "users")
		private User user;
		
		@ManyToOne
		@JoinColumn(name = "actividades")
		private Actividad actividad;
			
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
		
		public void setUser(User user) {
			this.user = user;
		}	
				//Parametro Actividad
		
		public Actividad getActividad() {
			return this.actividad;
		}
		
		public void setActividad(Actividad actividad) {
			this.actividad = actividad;
		}	
}





