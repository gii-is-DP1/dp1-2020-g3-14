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
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.ReservaHabitacion;
import org.springframework.samples.petclinic.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class ReservaHabitacionServiceTests {                
        @Autowired
	protected ReservaHabitacionService reservaHabitacionService; 

    @Test
    @Transactional
    public void shouldInsertReservaHabitacion() {
    	Collection<ReservaHabitacion> reservaHabitaciones = this.reservaHabitacionService.buscarReservaHabitacion("enrmorvaz");
    	//No debe existir la ReservaHabitacion con ese asociado a ese nombre de usuario en la base de datos
    	int found = reservaHabitaciones.size();
    	//Tamaño 0
    	System.out.println("==========================================================");
    	System.out.println("ReservaHabitacion Usuario enrmorvaz no encontrada. Found= "+found);
    	System.out.println("==========================================================");

    	ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
    	reservaHabitacion.setFechaReserva(LocalDate.now());
    	reservaHabitacion.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaHabitacion.setSalida(LocalDate.of(2021, 3, 22));
    	reservaHabitacion.setNumeroTarjeta("1111111111111111");
    	reservaHabitacion.setCvc("123");
    	reservaHabitacion.setPrecioFinal(20);
    	//Creamos usuario
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaHabitacion.setUser(usuario);
    	//Creamos hotel
    	Hotel hotel = new Hotel();
		hotel.setNombre("HOTEL 2");
		hotel.setDireccion("Calle Cano");
		hotel.setEstrellas(2);
		hotel.setProvincia("Sevilla");
		hotel.setTelefono("322222222");
    	//Creamos habitacion
		Habitacion habitacion = new Habitacion();
    	habitacion.setNhabitacion(123);
    	habitacion.setPrecio(23);
    	habitacion.setDisponible(true);
    	habitacion.setNcamas(2);
    	habitacion.setHotel(hotel);
    	//Creamos un set añadimos la habitacion
    	Set<Habitacion> habitaciones= new HashSet<Habitacion>();
		habitaciones.add(habitacion);
		hotel.setHabitaciones(habitaciones);       
    	//Añadimos la habitacion
    	reservaHabitacion.setHabitacion(habitacion);
    	
    	this.reservaHabitacionService.saveReservaHabitacion(reservaHabitacion);
    	
    	System.out.println("assertThat"+reservaHabitacion.getId());
    	assertThat(reservaHabitacion.getId()).isNotEqualTo(0);
    		
    	//Comprobamos que se ha añadido sin problemas
    	reservaHabitaciones = this.reservaHabitacionService.buscarReservaHabitacion("enrmorvaz");
    	assertThat(reservaHabitaciones.size()).isEqualTo(found+1);
    	System.out.println("reservaHabitacion enrmorvaz encontrada. Found= "+reservaHabitaciones.size());
    	System.out.println("==========================================================");
    }
    	
    @Test
    @Transactional
    public void shouldInsertReservaHabitacionVacio() {
    	
    	ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
    	reservaHabitacion.setFechaReserva(LocalDate.now());
    	reservaHabitacion.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaHabitacion.setSalida(LocalDate.of(2021, 3, 22));
    	reservaHabitacion.setNumeroTarjeta("");
    	reservaHabitacion.setCvc("");
    	reservaHabitacion.setPrecioFinal(20);
    	//Creamos usuario
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaHabitacion.setUser(usuario);
    	//Creamos hotel
    	Hotel hotel = new Hotel();
		hotel.setNombre("HOTEL 2");
		hotel.setDireccion("Calle Cano");
		hotel.setEstrellas(2);
		hotel.setProvincia("Sevilla");
		hotel.setTelefono("322222222");
    	//Creamos habitacion
		Habitacion habitacion = new Habitacion();
    	habitacion.setNhabitacion(123);
    	habitacion.setPrecio(23);
    	habitacion.setDisponible(true);
    	habitacion.setNcamas(2);
    	habitacion.setHotel(hotel);
    	//Creamos un set añadimos la habitacion
    	Set<Habitacion> habitaciones= new HashSet<Habitacion>();
		habitaciones.add(habitacion);
		hotel.setHabitaciones(habitaciones);       
    	//Añadimos la habitacion
    	reservaHabitacion.setHabitacion(habitacion);
    	assertThat(reservaHabitacion.getNumeroTarjeta().isEmpty()).isTrue();
    	assertThat(reservaHabitacion.getCvc().isEmpty()).isTrue();
    }
    

	@Test
	void shouldFindReservaHabitacionByName() {
		ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
    	reservaHabitacion.setFechaReserva(LocalDate.now());
    	reservaHabitacion.setEntrada(LocalDate.of(2021, 3, 3));
    	reservaHabitacion.setSalida(LocalDate.of(2021, 3, 22));
    	reservaHabitacion.setNumeroTarjeta("1111111111111111");
    	reservaHabitacion.setCvc("123");
    	reservaHabitacion.setPrecioFinal(20);
    	//Creamos usuario
    	User usuario = new User();
    	usuario.setUsername("enrmorvaz");
    	reservaHabitacion.setUser(usuario);
    	//Creamos hotel
    	Hotel hotel = new Hotel();
		hotel.setNombre("HOTEL 2");
		hotel.setDireccion("Calle Cano");
		hotel.setEstrellas(2);
		hotel.setProvincia("Sevilla");
		hotel.setTelefono("322222222");
    	//Creamos habitacion
		Habitacion habitacion = new Habitacion();
    	habitacion.setNhabitacion(123);
    	habitacion.setPrecio(23);
    	habitacion.setDisponible(true);
    	habitacion.setNcamas(2);
    	habitacion.setHotel(hotel);
    	//Creamos un set añadimos la habitacion
    	Set<Habitacion> habitaciones= new HashSet<Habitacion>();
		habitaciones.add(habitacion);
		hotel.setHabitaciones(habitaciones);       
    	//Añadimos la habitacion
    	reservaHabitacion.setHabitacion(habitacion);
                
		this.reservaHabitacionService.saveReservaHabitacion(reservaHabitacion);
		Collection<ReservaHabitacion> reservaVuelos = this.reservaHabitacionService.buscarReservaHabitacion("enrmorvaz");
		assertThat(reservaVuelos.size()).isEqualTo(1);
	}
	

	@Test
	void shouldNotFindReservaVueloByName() {
		Collection<ReservaHabitacion> reservaHabitaciones = this.reservaHabitacionService.buscarReservaHabitacion("enrmorvaz");
		assertThat(reservaHabitaciones.isEmpty()).isTrue();
	}
}
