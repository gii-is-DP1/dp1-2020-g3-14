package org.springframework.samples.petclinic.model;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Entity
@Table(name="reservas")

public class Reserva extends BaseEntity {
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
	
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
//	private Set<Vuelo> vuelos;
	
	
	// LO DEJE COMENTADO POR PRUDENSIA	
}
