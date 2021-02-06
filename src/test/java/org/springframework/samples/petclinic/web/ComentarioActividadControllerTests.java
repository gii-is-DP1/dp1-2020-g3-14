package org.springframework.samples.petclinic.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.petclinic.configuration.SecurityConfiguration;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ComentarioActividad;
import org.springframework.samples.petclinic.model.ComentarioHotel;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.ComentarioActividadService;
import org.springframework.samples.petclinic.service.ComentarioHotelService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=ComentarioActividadController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class ComentarioActividadControllerTests {
	
	private static final int TEST_COMENTARIOACTIVIDAD_ID = 1;
	private static final int TEST_ACTIVIDAD_ID = 1;
	
	@Autowired
	private ComentarioActividadController comentarioActividadController;

	@MockBean
	private ComentarioActividadService comentarioActividadService;
	@MockBean
	private ActividadService actividadService;
        
    
	@Autowired
	private MockMvc mockMvc;

	private ComentarioActividad comentario;
	
	//Creamos el hotel
	@BeforeEach
	void setup() {

		Actividad actividad = new Actividad();
		actividad.setId(TEST_ACTIVIDAD_ID);
		actividad.setNombre("Escalada");
		actividad.setDescripcion("Buena ruta de escala con amigos");
		actividad.setValoracion(4);
		actividad.setDireccion("Sierra de Grazalema");
		actividad.setPrecio(2);
		
		comentario=new ComentarioActividad();
		comentario.setActividad(actividad);;
		comentario.setMensaje("Bueno");
		comentario.setId(TEST_COMENTARIOACTIVIDAD_ID);
		comentario.setPuntuacion(6);

		given(this.comentarioActividadService.findComentarioById(TEST_COMENTARIOACTIVIDAD_ID)).willReturn(new ComentarioActividad());
		given(this.actividadService.findActividadById(TEST_ACTIVIDAD_ID)).willReturn(new Actividad());
	}
	
	@WithMockUser(value = "spring")
        @Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/actividades/{actividadId}/comentarios/new",TEST_ACTIVIDAD_ID)).andExpect(status().isOk()).andExpect(model().attributeExists("comentario"))
				.andExpect(view().name("actividades/createComentarioForm")).andExpect(model().attributeExists("comentario"));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/actividades/{actividadId}/comentarios/new",TEST_ACTIVIDAD_ID)
							.with(csrf())
							.param("mensaje", "Lujo")
							.param("puntuacion", "4")
							)
				.andExpect(status().is3xxRedirection()).andExpect(view().name("redirect:/actividades/"+TEST_ACTIVIDAD_ID));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormHasErrors() throws Exception {
		mockMvc.perform(post("/actividades/{actividadId}/comentarios/new",TEST_ACTIVIDAD_ID)
							.with(csrf())
							.param("mensaje", "")
							.param("puntuacion", "4")
							)
				.andExpect(model().attributeHasNoErrors("actividad"))
				.andExpect(status().isOk())
				.andExpect(view().name("actividades/createComentarioForm"));
	}
}
