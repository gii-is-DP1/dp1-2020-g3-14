package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;

import lombok.Data;


@Entity
@Table(name = "habitaciones")
public class Habitacion{
	
	@Id
	Integer nhabitacion;
	
	@Column(name = "ncamas")
	@Range(min=1,max=5)
	private Integer ncamas;
	
	@Column(name = "precio")
	private Integer precio;
	
	@Column(name = "disponible")
	private Boolean disponible;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;
	
	@ManyToMany(mappedBy = "habitaciones")
	private Set<User> users;
	
	
	
	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Integer getNhabitacion() {
		return nhabitacion;
	}

	public void setNhabitacion(Integer nhabitacion) {
		this.nhabitacion = nhabitacion;
	}

	public Integer getNcamas() {
		return ncamas;
	}

	public void setNcamas(Integer ncamas) {
		this.ncamas = ncamas;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	
	protected Set<User> getUsersInternal() {
		if (this.users == null) {
			this.users = new HashSet<>();
		}
		return this.users;
	}

	public List<User> getUsers() {
		List<User> sortedUsers = new ArrayList<>(getUsersInternal());
		PropertyComparator.sort(sortedUsers, new MutableSortDefinition("username", true, true));
		return Collections.unmodifiableList(sortedUsers);
	}

	public void setUsersInternal(Set<User> users) {
		this.users = users;
	}

	
	

}
