package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.ComentarioHotel;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class ComentarioHotelServiceTests {                
        @Autowired
	protected ComentarioHotelService comentarioHotelService;
        @Autowired
    protected HotelService hotelService;
        
	//Prueba H7+E1 - Alta de un comentario
	@Test
	@Transactional
	public void shouldInsertComentarioHotel() {
	
		//Primero creamos el hotel
		Hotel hotel = new Hotel();
		hotel.setNombre("Sunset");
		hotel.setDireccion("Calle Overdrive");
		hotel.setEstrellas(4);
		hotel.setProvincia("Granada");
		hotel.setTelefono("666555111");
		
			//Opcional, como está relacionado con habitaciones le creo 2 habitaciones
			Habitacion hab1=new Habitacion();
				hab1.setNhabitacion(001);
				hab1.setNcamas(2);
				hab1.setPrecio(541);
				hab1.setDisponible(true);
				hab1.setHotel(hotel);
				
			Habitacion hab2=new Habitacion();
				hab2.setNhabitacion(002);
				hab2.setNcamas(2);
				hab2.setPrecio(541);
				hab2.setDisponible(true);
				hab2.setHotel(hotel);
				
			Set<Habitacion> habitaciones=new HashSet<Habitacion>(); 
				habitaciones.add(hab1);
				habitaciones.add(hab2);
        
        //Añado las habitaciones
        hotel.setHabitaciones(habitaciones);
         
		this.hotelService.saveHotel(hotel);
		assertThat(hotel.getId()).isNotEqualTo(0);
		
		//A continuacion creamos el comentario en el hotel
		ComentarioHotel comentario=new ComentarioHotel();
		comentario.setMensaje("Buen hotel");
		comentario.setPuntuacion(4);
		comentario.setHotel(hotel);
		this.comentarioHotelService.saveComentario(comentario);
		ComentarioHotel comentario2=this.comentarioHotelService.findComentarioById(comentario.getId());
		assertThat(comentario.getId()).isEqualTo(comentario2.getId());

    }
	
	//Prueba H7-E1 - Alta de un comentario sin mensaje y sin puntuacion
	@Test
	@Transactional
	public void shouldInsertComentarioHotelVacio() {
		ComentarioHotel comentario=new ComentarioHotel();
		comentario.setMensaje("Mejor hotel calidad precio");
		comentario.setPuntuacion(null);
		
        assertThat(comentario.getPuntuacion()).isNull();
    }
}
