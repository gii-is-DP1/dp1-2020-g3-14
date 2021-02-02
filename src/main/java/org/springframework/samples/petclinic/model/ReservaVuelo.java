package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservasvuelo")

public class ReservaVuelo extends BaseEntity{

		@Column(name = "fechareserva")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		private LocalDate fechaReserva;
		
		@Column(name = "ida")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		@FutureOrPresent
		private LocalDate ida;
		
		@Column(name = "vuelta")
		@DateTimeFormat(pattern = "yyyy/MM/dd")
		@FutureOrPresent
		private LocalDate vuelta;
		
		@Column(name = "numeroTarjeta")
		@Pattern(regexp="\\d{16}")
		private String numeroTarjeta;
		
		@Column(name = "cvc")
		@Pattern(regexp="\\d{3}")
		private String cvc;
		
		@Column(name="precio")
		private Integer precioFinal;
		
		@ManyToOne
		@JoinColumn(name = "username")
		private User user;
		
		@OneToOne
		@JoinColumn(name = "vuelo_id")
		private Vuelo vuelo;

		public LocalDate getFechaReserva() {
			return fechaReserva;
		}

		public void setFechaReserva(LocalDate fechaReserva) {
			this.fechaReserva = fechaReserva;
		}

		public LocalDate getIda() {
			return ida;
		}

		public void setIda(LocalDate ida) {
			this.ida = ida;
		}

		public LocalDate getVuelta() {
			return vuelta;
		}

		public void setVuelta(LocalDate vuelta) {
			this.vuelta = vuelta;
		}

		public String getNumeroTarjeta() {
			return numeroTarjeta;
		}

		public void setNumeroTarjeta(String numeroTarjeta) {
			this.numeroTarjeta = numeroTarjeta;
		}

		public String getCvc() {
			return cvc;
		}

		public void setCvc(String cvc) {
			this.cvc = cvc;
		}

		public Integer getPrecioFinal() {
			return precioFinal;
		}

		public void setPrecioFinal(Integer precioFinal) {
			this.precioFinal = precioFinal;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Vuelo getVuelo() {
			return vuelo;
		}

		public void setVuelo(Vuelo vuelo) {
			this.vuelo = vuelo;
		}

		
		
}