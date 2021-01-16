package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservashabitacion")

public class ReservaHabitacion extends BaseEntity{

		@Column(name = "fechareserva")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private LocalDate fechaReserva;
		
		@Column(name = "entrada")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private LocalDate entrada;
		
		@Column(name = "salida")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private LocalDate salida;
		
		@Column(name = "numeroTarjeta")
		@Pattern(regexp="\\d{16}")
		private String numeroTarjeta;
		
		@Column(name = "cvc")
		@Pattern(regexp="\\d{3}")
		private String cvc;
		
		@ManyToOne
		@JoinColumn(name = "username")
		private User user;
		
		@OneToOne
		@JoinColumn(name = "habitacion_id")
		private Habitacion habitacion;

		public LocalDate getFechaReserva() {
			return fechaReserva;
		}

		public void setFechaReserva(LocalDate fechaReserva) {
			this.fechaReserva = fechaReserva;
		}

		public LocalDate getEntrada() {
			return entrada;
		}

		public void setEntrada(LocalDate entrada) {
			this.entrada = entrada;
		}

		public LocalDate getSalida() {
			return salida;
		}

		public void setSalida(LocalDate salida) {
			this.salida = salida;
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

		public User getUser() {
			return this.user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Habitacion getHabitacion() {
			return habitacion;
		}

		public void setHabitacion(Habitacion habitacion) {
			this.habitacion = habitacion;
		}
		
}
