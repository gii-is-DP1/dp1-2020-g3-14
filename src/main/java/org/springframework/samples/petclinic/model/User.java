package org.springframework.samples.petclinic.model;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;


@Entity
@Table(name = "users")
public class User {
	@Id
	@NotEmpty
	String username;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$ "
			+ " (mínimo 8 caracteres, una letra minúscula,una letra mayúscula, sin espacios)")
	String password;
	
	@Column(name = "telefono")
	@NotEmpty
	@Digits(fraction = 0, integer = 10)
	private String telefono;
	
	@Column(name = "dni")
	@NotEmpty
	@Pattern(regexp = "^[0-9]{8,8}[A-Za-z]$"
			+ " (8 números y una letra)")
	private String dni;
	
	boolean enabled;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Authorities> authorities;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<Reserva> reservas;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE})
	@JoinTable(
			name = "personas_actividades",
			joinColumns = {@JoinColumn(name = "username")},
	        inverseJoinColumns = {@JoinColumn(name = "actividades_id")}
			)
	private Set<Actividad> actividades;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Authorities> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	protected Set<Reserva> getReservasInternal() {
		if (this.reservas == null) {
			this.reservas = new HashSet<>();
		}
		return this.reservas;
	}

	protected void setReservasInternal(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public List<Reserva> getReservas() {
		List<Reserva> sortedReservas = new ArrayList<>(getReservasInternal());
		PropertyComparator.sort(sortedReservas, new MutableSortDefinition("fecha", true, true));
		return Collections.unmodifiableList(sortedReservas);
	}

	public void addReserva(Reserva reserva) {
		getReservasInternal().add(reserva);
		reserva.setUser(this);
	}
	
	public boolean removeReserva(Reserva reserva) {
		return getReservasInternal().remove(reserva);
	}
	
	protected Set<Actividad> getActividadesInternal() {
		if (this.actividades == null) {
			this.actividades = new HashSet<>();
		}
		return this.actividades;
	}

	protected void setActividadesInternal(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public List<Actividad> getActividades() {
		List<Actividad> sortedActividades = new ArrayList<>(getActividadesInternal());
		PropertyComparator.sort(sortedActividades, new MutableSortDefinition("nombre", true, true));
		return Collections.unmodifiableList(sortedActividades);
	}

	public void addActividad(Actividad actividad) {
		getActividadesInternal().add(actividad);
	}
	
	public boolean removeActividad(Actividad actividad) {
		return getActividadesInternal().remove(actividad);
	}
	
	public boolean isNew() {
		return this.username == null;
	}
}
