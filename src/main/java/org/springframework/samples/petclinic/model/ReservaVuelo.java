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


@Entity
@Table(name="reservasVuelo")

public class ReservaVuelo extends BaseEntity {
	
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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vuelo")
	private Set<Vuelo> vuelos;
	
	
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
			//Parametro vuelos
	
	public Set<Vuelo> getVuelos() {
		return vuelos;
	}
	
	public void setVuelos (Set<Vuelo> newVuelos) {
		this.vuelos = newVuelos;
	}
	
	
	
}
