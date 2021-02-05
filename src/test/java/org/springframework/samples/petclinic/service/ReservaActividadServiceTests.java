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
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class ReservaActividadServiceTests {                
        @Autowired
	protected ReservaActividadService reservaActividadService; 

    @Test
    @Transactional
    public void shouldInsertReservaActividad() {
    	Collection<ReservaActividad> reservaActividades = this.reservaActividadService.buscarReservaActividad("enrmorvaz");
    	//No debe existir la Reservaactividad con ese asociado a ese nombre de usuario en la base de datos
    	int found = reservaActividades.size();
    	//Tamaño 0
    	System.out.println("==========================================================");
    	System.out.println("ReservaActividad Usuario enrmorvaz no encontrada. Found= "+found);
    	System.out.println("==========================================================");

    	ReservaActividad reservaActividad = new ReservaActividad();
    	reservaActividad.setFechaReserva(LocalDate.now());
    	reservaActividad.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaActividad.setNumeroTarjeta("1111111111111111");
    	reservaActividad.setCvc("123");
    	reservaActividad.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaActividad.setUser(usuario);
    	
    	this.reservaActividadService.saveReservaActividad(reservaActividad);
    	
    	System.out.println("assertThat"+reservaActividad.getId());
    	assertThat(reservaActividad.getId()).isNotEqualTo(0);
    		
    	//Comprobamos que se ha añadido sin problemas
    	reservaActividades = this.reservaActividadService.buscarReservaActividad("enrmorvaz");
    	assertThat(reservaActividades.size()).isEqualTo(found+1);
    	System.out.println("reservaActividad enrmorvaz encontrada. Found= "+reservaActividades.size());
    	System.out.println("==========================================================");
    }
    	
    @Test
    @Transactional
    public void shouldInsertReservaActividadVacio() {
    	
    	ReservaActividad reservaActividad = new ReservaActividad();
    	reservaActividad.setFechaReserva(LocalDate.now());
    	reservaActividad.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaActividad.setNumeroTarjeta("");
    	reservaActividad.setCvc("");
    	reservaActividad.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaActividad.setUser(usuario);
        assertThat(reservaActividad.getNumeroTarjeta().isEmpty()).isTrue();
    	assertThat(reservaActividad.getCvc().isEmpty()).isTrue();
    }
    

	@Test
	void shouldFindReservaActividadByName() {
		ReservaActividad reservaActividad = new ReservaActividad();
    	reservaActividad.setFechaReserva(LocalDate.now());
    	reservaActividad.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaActividad.setNumeroTarjeta("1111111111111111");
    	reservaActividad.setCvc("123");
    	reservaActividad.setPrecioFinal(20);
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaActividad.setUser(usuario);   
                
		this.reservaActividadService.saveReservaActividad(reservaActividad);
		Collection<ReservaActividad> reservaActividades = this.reservaActividadService.buscarReservaActividad("enrmorvaz");
		assertThat(reservaActividades.size()).isEqualTo(1);
	}
	

	@Test
	void shouldNotFindReservaActividadByName() {
		Collection<ReservaActividad> reservaActividad = this.reservaActividadService.buscarReservaActividad("enrmorvaz");
		assertThat(reservaActividad.isEmpty()).isTrue();
	}
}
