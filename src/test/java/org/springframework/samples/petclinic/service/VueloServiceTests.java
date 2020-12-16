package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class VueloServiceTests {                
        @Autowired
	protected VueloService vueloService;

	@Test
	void shouldFindVueloByProvincia() {
		Vuelo vuelo = new Vuelo();
		vuelo.setBilletes(451);
		vuelo.setDestino("Malaga");
		vuelo.setOrigen("Sevilla");
		vuelo.setPrecio(12);
		
		this.vueloService.saveVuelo(vuelo);
		Collection<Vuelo> vuelos = this.vueloService.findByOrigen("Sevilla");
		assertThat(vuelos.size()).isEqualTo(3);

		vuelos = this.vueloService.findByOrigen("Andalucia");
		assertThat(vuelos.isEmpty()).isTrue();
	}
	
	@Test
	@Transactional
	public void shouldInsertVuelo() {
		
		Collection<Vuelo> vuelos = this.vueloService.findByOrigen("Sevilla");
		//No debe existir el hotel con ese nombre en la base de datos
		int found = vuelos.size();

		Vuelo vuelo = new Vuelo();
		vuelo.setBilletes(451);
		vuelo.setDestino("Malaga");
		vuelo.setOrigen("Sevilla");
		vuelo.setPrecio(12);
		
		this.vueloService.saveVuelo(vuelo);
		
		vuelos = this.vueloService.findByOrigen("Sevilla");
		assertThat(vuelos.size()).isEqualTo(found+1);
		
    }
}