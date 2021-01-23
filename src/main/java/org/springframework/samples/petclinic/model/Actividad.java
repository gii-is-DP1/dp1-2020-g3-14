package org.springframework.samples.petclinic.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Range;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;


@Entity
@Table(name = "actividades")	
public class Actividad extends BaseEntity{

	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "opinion")
	@NotEmpty
	private String opinion;
	
	@Column(name = "valoracion")
	@Range(min=1,max=5)
	private Integer valoracion;
	
	@Column(name = "direccion")
	@NotEmpty
	private String direccion;

	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "precio")
	@NotEmpty
	@Digits(fraction = 0, integer = 8)
	private String precio;
	
	@ManyToOne
	@JoinColumn(name = "agenact_id")
	private AgenAct agenact;
	
	@ManyToMany(mappedBy = "actividades")
	private Set<User> users;
	
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "actividad")
	private List<ComentarioActividad> comentarios;
	
	
	public List<ComentarioActividad> getComentarios() {
		return comentarios;
	}
	
	public void setComentarios(List<ComentarioActividad> comentarios) {
		this.comentarios = comentarios;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public Integer getValoracion() {
		return valoracion;
	}

	public void setValoracion(Integer valoracion) {
		this.valoracion = valoracion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public AgenAct getAgenact() {
		return agenact;
	}

	public void setAgenact(AgenAct agenact) {
		this.agenact = agenact;
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
