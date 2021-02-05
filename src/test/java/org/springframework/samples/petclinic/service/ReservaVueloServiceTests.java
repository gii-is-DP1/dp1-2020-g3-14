/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class ReservaVueloServiceTests {                
        @Autowired
	protected ReservaVueloService reservaVueloService; 

    @Test
    @Transactional
    public void shouldInsertReservaVuelo() {
    	Collection<ReservaVuelo> reservaVuelos = this.reservaVueloService.buscarReservaVuelo("enrmorvaz");
    	//No debe existir la ReservaVuelo con ese asociado a ese nombre de usuario en la base de datos
    	int found = reservaVuelos.size();
    	//Tamaño 0
    	System.out.println("==========================================================");
    	System.out.println("ReservaVuelo Usuario enrmorvaz no encontrada. Found= "+found);
    	System.out.println("==========================================================");

    	ReservaVuelo reservaVuelo = new ReservaVuelo();
    	reservaVuelo.setFechaReserva(LocalDate.now());
    	reservaVuelo.setIda(LocalDate.of(2021, 3, 3));
    	reservaVuelo.setVuelta(LocalDate.of(2021, 3, 22));
    	reservaVuelo.setNumeroTarjeta("1111111111111111");
    	reservaVuelo.setCvc("123");
    	reservaVuelo.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaVuelo.setUser(usuario);
    	
    	this.reservaVueloService.saveReservaVuelo(reservaVuelo);
    	
    	System.out.println("assertThat"+reservaVuelo.getId());
    	assertThat(reservaVuelo.getId()).isNotEqualTo(0);
    		
    	//Comprobamos que se ha añadido sin problemas
    	reservaVuelos = this.reservaVueloService.buscarReservaVuelo("enrmorvaz");
    	assertThat(reservaVuelos.size()).isEqualTo(found+1);
    	System.out.println("reservaVuelo enrmorvaz encontrada. Found= "+reservaVuelos.size());
    	System.out.println("==========================================================");
    }
    	
    @Test
    @Transactional
    public void shouldInsertReservaVueloVacio() {
    	
    	ReservaVuelo reservaVuelo = new ReservaVuelo();
    	reservaVuelo.setFechaReserva(LocalDate.now());
    	reservaVuelo.setIda(LocalDate.of(2021, 3, 3));
    	reservaVuelo.setVuelta(LocalDate.of(2021, 3, 22));
    	reservaVuelo.setNumeroTarjeta("");
    	reservaVuelo.setCvc("");
    	reservaVuelo.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaVuelo.setUser(usuario);
        assertThat(reservaVuelo.getNumeroTarjeta().isEmpty()).isTrue();
    	assertThat(reservaVuelo.getCvc().isEmpty()).isTrue();
    }
    

	@Test
	void shouldFindReservaVueloByName() {
		ReservaVuelo reservaVuelo = new ReservaVuelo();
    	reservaVuelo.setFechaReserva(LocalDate.now());
    	reservaVuelo.setIda(LocalDate.of(2021, 3, 3));
    	reservaVuelo.setVuelta(LocalDate.of(2021, 3, 22));
    	reservaVuelo.setNumeroTarjeta("1111111111111111");
    	reservaVuelo.setCvc("123");
    	reservaVuelo.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaVuelo.setUser(usuario);
                
		this.reservaVueloService.saveReservaVuelo(reservaVuelo);
		Collection<ReservaVuelo> reservaVuelos = this.reservaVueloService.buscarReservaVuelo("enrmorvaz");
		assertThat(reservaVuelos.size()).isEqualTo(1);
	}
	

	@Test
	void shouldNotFindReservaVueloByName() {
		Collection<ReservaVuelo> reservaVuelos = this.reservaVueloService.buscarReservaVuelo("enrmorvaz");
		assertThat(reservaVuelos.isEmpty()).isTrue();
	}
}
