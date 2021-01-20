package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "codigo")	
public class Codigo extends BaseEntity{
	
	@Id
	String patron;
	
	@Column(name = "nvecesusado")
	private Integer nvecesusado;
	
	@Column(name = "valido")
	private Boolean valido;

	public String getPatron() {
		return patron;
	}

	public void setPatron(String patron) {
		this.patron = patron;
	}

	public Integer getNvecesusado() {
		return nvecesusado;
	}

	public void setNvecesusado(Integer nvecesusado) {
		this.nvecesusado = nvecesusado;
	}

	public Boolean getValido() {
		return valido;
	}

	public void setValido(Boolean valido) {
		this.valido = valido;
	}
	

}
