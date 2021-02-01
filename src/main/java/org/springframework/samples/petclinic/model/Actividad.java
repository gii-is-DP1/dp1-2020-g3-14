package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
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
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "actividades")	
public class Actividad extends BaseEntity{

	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;

	@Column(name = "descripcion")
	@NotEmpty
	private String descripcion;
	
	@Column(name = "valoracion")
	@Range(min=0,max=10)
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
	
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fecha;
	
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public void setUsersInternal(Set<User> users) {
		this.users = users;
	}

}
