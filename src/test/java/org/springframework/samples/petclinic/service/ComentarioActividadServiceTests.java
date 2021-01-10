package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ComentarioActividad;
import org.springframework.samples.petclinic.model.ComentarioHotel;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class ComentarioActividadServiceTests {                
        @Autowired
	protected ComentarioActividadService comentarioActividadService;
        @Autowired
    protected ActividadService actividadService;
        
	//Prueba H9+E1 - Alta de un comentario
	@Test
	@Transactional
	public void shouldInsertComentarioActividad() {
	
		Actividad actividad = new Actividad();
		actividad.setNombre("Escalada");
		actividad.setOpinion("Buena ruta de escala con amigos");
		actividad.setValoracion(4);
		actividad.setDireccion("Sierra de Grazalema");
		actividad.setPrecio("2");
		this.actividadService.saveActividad(actividad);
		assertThat(actividad.getId()).isNotEqualTo(0);
		
		//A continuacion creamos el comentario de la actividad
		ComentarioActividad comentario=new ComentarioActividad();
		comentario.setActividad(actividad);
		comentario.setMensaje("Bueno");
		comentario.setPuntuacion(6);
		this.comentarioActividadService.saveComentario(comentario);
		assertThat(comentario.getId()).isNotEqualTo(0);
    }
	
	//Prueba H9-E1 - Alta de un comentario sin mensaje y sin puntuacion
	@Test
	@Transactional
	public void shouldInsertComentarioActividadVacio() {
		ComentarioActividad comentario=new ComentarioActividad();
		comentario.setMensaje("Mejor hotel calidad precio");
		comentario.setPuntuacion(null);
        assertThat(comentario.getPuntuacion()).isNull();
    }
}
