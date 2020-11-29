package org.springframework.samples.petclinic.model;

import java.util.Set; 

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
	
	public boolean isNew() {
		return this.username == null;
	}
}
