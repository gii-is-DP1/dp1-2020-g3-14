package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.core.style.ToStringCreator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "vuelos")
public class Vuelo extends BaseEntity {
	
	@Column(name = "billetes")
	@NotEmpty
	private Integer billetes;

	@Column(name = "origen")
	@NotEmpty
	private String origen;
	
	@Column(name = "destino")
	@NotEmpty
	private String destino;
	
	@Column(name = "fechaIda")
	@NotEmpty
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaIda;
	
	@Column(name = "fechaVuelta")
	@NotEmpty
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaVuelta;
	
	@Column(name = "precio")
	@NotEmpty
	private Integer precio;

		
	public Integer getBilletes() {
		return billetes;
	}

	public void setBilletes(Integer billetes) {
		this.billetes = billetes;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public LocalDate getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(LocalDate fechaIda) {
		this.fechaIda = fechaIda;
	}

	public LocalDate getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(LocalDate fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("billetes", this.getBilletes())
				.append("origen", this.origen).append("destino", this.destino).append("fechaIda", this.fechaIda).
				append("fechaVuelta", this.fechaVuelta).append("precio", this.precio).toString();
	}
}
