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
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration test of the Service and the Repository layer.
 * <p>
 * ClinicServiceSpringDataJpaTests subclasses benefit from the following services provided
 * by the Spring TestContext Framework:
 * </p>
 * <ul>
 * <li><strong>Spring IoC container caching</strong> which spares us unnecessary set up
 * time between test execution.</li>
 * <li><strong>Dependency Injection</strong> of test fixture instances, meaning that we
 * don't need to perform application context lookups. See the use of
 * {@link Autowired @Autowired} on the <code>{@link
 * OwnerServiceTests#clinicService clinicService}</code> instance variable, which uses
 * autowiring <em>by type</em>.
 * <li><strong>Transaction management</strong>, meaning each test method is executed in
 * its own transaction, which is automatically rolled back by default. Thus, even if tests
 * insert or otherwise change database state, there is no need for a teardown or cleanup
 * script.
 * <li>An {@link org.springframework.context.ApplicationContext ApplicationContext} is
 * also inherited and can be used for explicit bean lookup if necessary.</li>
 * </ul>
 *
 * @author Ken Krebs
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @author Michael Isvy
 * @author Dave Syer
 */

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class HotelServiceTests {                
        @Autowired
	protected HotelService hotelService;

	@Test
	void shouldFindHotelByName() {
		Hotel hotel = new Hotel();
		hotel.setNombre("HOTEL 0");
		hotel.setDireccion("Calle Cano");
		hotel.setEstrellas(2);
		hotel.setProvincia("Sevilla");
		hotel.setTelefono("322222222");
		
		Habitacion habitacion1= new Habitacion();		
		habitacion1.setDisponible(true);
		habitacion1.setNcamas(2);
		habitacion1.setNhabitacion(444);
		habitacion1.setPrecio(25);
		habitacion1.setHotel(hotel);
		Set<Habitacion> habitaciones= new HashSet<Habitacion>();
		habitaciones.add(habitacion1);
		hotel.setHabitaciones(habitaciones);              
                
		this.hotelService.saveHotel(hotel);
		Collection<Hotel> hoteles = this.hotelService.findByNombre("HOTEL 0");
		assertThat(hoteles.size()).isEqualTo(2);

		hoteles = this.hotelService.findByNombre("Pepes");
		assertThat(hoteles.isEmpty()).isTrue();
	}
	
	@Test
	@Transactional
	public void shouldInsertHotel() {
		Collection<Hotel> hoteles = this.hotelService.findByNombre("HOTEL 2");

		Hotel hotel = new Hotel();
		hotel.setNombre("HOTEL 2");
		hotel.setDireccion("Calle Cano");
		hotel.setEstrellas(3);
		hotel.setProvincia("Sevilla");
		hotel.setTelefono("32222222");
		
		Habitacion habitacion1= new Habitacion();
		habitacion1.setDisponible(true);
		habitacion1.setNcamas(2);
		habitacion1.setNhabitacion(444);
		habitacion1.setPrecio(25);
		habitacion1.setHotel(hotel);
		Set<Habitacion> habitaciones= new HashSet<Habitacion>();
		habitaciones.add(habitacion1);
		hotel.setHabitaciones(habitaciones);              
                
		this.hotelService.saveHotel(hotel);		
		hoteles = this.hotelService.findByNombre("HOTEL 2");
		assertThat(hoteles.size()).isEqualTo(1);
	}
}
