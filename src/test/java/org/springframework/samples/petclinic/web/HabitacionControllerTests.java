package org.springframework.samples.petclinic.web;

import static org.mockito.BDDMockito.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.petclinic.configuration.SecurityConfiguration;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.service.HabitacionService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=HabitacionController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class HabitacionControllerTests {
	
	private static final int TEST_HABITACION_ID = 1;
	
	@Autowired
	private HabitacionController habitacionController;

	@MockBean
	private HabitacionService habitacionService;
	
	@MockBean
	private HotelService hotelService;
        
    
	@Autowired
	private MockMvc mockMvc;

	private Habitacion habitacion;
	
	//Creamos la habitacion
	@BeforeEach
	void setup() {

		habitacion = new Habitacion();
		habitacion.setNhabitacion(TEST_HABITACION_ID);
		habitacion.setNcamas(2);
		habitacion.setPrecio(20);
		habitacion.setDisponible(true);
		
		//Deberá devolver la habitacion
		given(this.habitacionService.findHabitacionById(TEST_HABITACION_ID)).willReturn(habitacion);

	}

	@WithMockUser(value = "spring")
    @Test
    void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/hoteles/1/habitaciones/new")).andExpect(status().isOk()).andExpect(model().attributeExists("habitacion"))
			.andExpect(view().name("habitaciones/createOrUpdateHabitacionForm"));
	}

	@WithMockUser(value = "spring")
    @Test
    void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/hoteles/1/habitaciones/new").param("nhabitacion", "666")
						.with(csrf())
						.param("ncamas", "1")
						.param("precio", "60")
						.param("disponible", "true"))
			.andExpect(status().is3xxRedirection());
	}
	
	@WithMockUser(value = "spring")
    @Test
    void testProcessCreationFormHasError() throws Exception {
		mockMvc.perform(post("/hoteles/2/habitaciones/new").param("nhabitacion", "666")
						.with(csrf())
						.param("ncamas", "78")
						.param("precio", "60")
						.param("disponible", "true"))
						.andExpect(status().isOk())
						.andExpect(model().attributeHasErrors("habitacion"))
						.andExpect(model().attributeHasFieldErrors("habitacion","ncamas"))
						.andExpect(view().name("habitaciones/createOrUpdateHabitacionForm"));
	}
	
}
	 
	