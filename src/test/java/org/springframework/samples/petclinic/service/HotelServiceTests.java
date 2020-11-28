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

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
public class HotelServiceTests {

	@Autowired
	protected HotelService hotelService;
	
	//Test dar de alta hotel
	@Test
	@Transactional
	public void shouldInsertHotel() {
		Collection<Hotel> hoteles = this.hotelService.findByNombre("Sunset");
		//No debe existir el hotel con ese nombre en la base de datos
		int found = hoteles.size();
		//Tamaño 0
		System.out.println("==========================================================");
		System.out.println("Hotel Sunset no encontrado. Found= "+found);
		System.out.println("==========================================================");

		Hotel hotel = new Hotel();
		hotel.setNombre("Sunset");
		hotel.setDireccion("Calle Overdrive");
		hotel.setEstrellas(4);
		hotel.setProvincia("Granada");
		hotel.setPrecio("4521");
		hotel.setTelefono("666555111");
		System.out.println("HOTEL: "+hotel);
		System.out.println("ID HOTEL: "+hotel.getId());
//		hotel.setId(1234);
		System.out.println("ID HOTEL: "+hotel.getId());
			//Opcional, como está relacionado con habitaciones le creo 2 habitaciones
			Habitacion hab1=new Habitacion();
				hab1.setNhabitacion(001);
				hab1.setNcamas(2);
				hab1.setPrecio(541);
				hab1.setDisponible(true);
				hab1.setHotel(hotel);
				System.out.println(hab1);
				
			Habitacion hab2=new Habitacion();
				hab2.setNhabitacion(002);
				hab2.setNcamas(2);
				hab2.setPrecio(541);
				hab2.setDisponible(true);
				hab2.setHotel(hotel);
                
				System.out.println(hab2);
				
			Set<Habitacion> habitaciones=new HashSet<Habitacion>(); 
				habitaciones.add(hab1);
				habitaciones.add(hab2);
        
        //Añado las habitaciones
        hotel.setHabitaciones(habitaciones);
         
		this.hotelService.saveHotel(hotel);
		System.out.println("assertThat"+hotel.getId());
		assertThat(hotel.getId()).isNotEqualTo(0);
		
		//Comprobamos que se ha añadido sin problemas
		hoteles = this.hotelService.findByNombre("Sunset");
		assertThat(hoteles.size()).isEqualTo(found+1);
		System.out.println("Hotel Sunset encontrado. Found= "+hoteles.size());
		System.out.println("==========================================================");


	}
}
