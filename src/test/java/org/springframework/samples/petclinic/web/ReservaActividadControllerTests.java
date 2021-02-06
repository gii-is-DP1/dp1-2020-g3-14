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

import java.time.LocalDate;
import java.time.Month;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.petclinic.configuration.SecurityConfiguration;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.samples.petclinic.service.ReservaActividadService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=ReservaActividadController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class ReservaActividadControllerTests {
	
	private static final int TEST_RESERVAACTIVIDAD_ID = 1;
	
	@Autowired
	private ReservaActividadController reservaActividadController;

	@MockBean
	private ReservaActividadService reservaActividadService;
	@MockBean
	private ActividadService actividadService;
	@MockBean
	private UserService userService;
    
	@Autowired
	private MockMvc mockMvc;

	
	private ReservaActividad reservaActividad;
	
	
	//Creamos la reserva
	@BeforeEach
	void setup() {

		reservaActividad = new ReservaActividad();
		reservaActividad.setFechaReserva(LocalDate.of(2021, 4, 10));
		reservaActividad.setEntrada(LocalDate.of(2021, 4, 13));
		reservaActividad.setNumeroTarjeta("1111111111111111");;
		reservaActividad.setCvc("333");
		reservaActividad.setPrecioFinal(100);

		//Deberá devolver el hotel
		given(this.reservaActividadService.findReservaActividadById(TEST_RESERVAACTIVIDAD_ID)).willReturn(reservaActividad);

	}
	

	@WithMockUser(value = "spring")
        @Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/actividades/{actividadId}/reservaActividad/new",1)).andExpect(status().isOk()).andExpect(model().attributeExists("reservaActividad"))
				.andExpect(view().name("reservaActividad/createReservaActividadForm"));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/actividades/{actividadId}/reservaActividad/new",1).param("fechaReserva", "2021/10/24")
							.with(csrf())
							.param("entrada", "2021/10/26")
							.param("numeroTarjeta", "2222222222222222")
							.param("cvc", "333")
							.param("precioFinal", "200"))
				.andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormHasErrors() throws Exception {
		mockMvc.perform(post("/actividades/{actividadId}/reservaActividad/new",TEST_RESERVAACTIVIDAD_ID)
							.with(csrf())
							.param("fechaReserva", "2021/10/24")
							.param("entrada", "2021/10/26")
							.param("numeroTarjeta", "1111111111111111")
							.param("cvc", "333")
							.param("precioFinal", ""))
				.andExpect(status().isOk())
				.andExpect(model().attributeHasErrors("reservaActividad"))
				.andExpect(model().attributeHasFieldErrors("reservaActividad","precioFinal"))
				.andExpect(view().name("reservaActividad/createReservaActividadForm"));
	}
	
     @WithMockUser(value = "spring")
	@Test
	void testShowReservaActividad() throws Exception {
		mockMvc.perform(get("/actividades/{actividadId}/reservaActividad/{reservaActividadId}",1, TEST_RESERVAACTIVIDAD_ID)).andExpect(status().isOk())
				.andExpect(model().attribute("reservaActividad", hasProperty("fechaReserva", is(LocalDate.of(2021, 4, 10)))))
				.andExpect(model().attribute("reservaActividad", hasProperty("entrada", is(LocalDate.of(2021, 4, 13)))))
				.andExpect(model().attribute("reservaActividad", hasProperty("numeroTarjeta", is("1111111111111111"))))
				.andExpect(model().attribute("reservaActividad", hasProperty("cvc", is("333"))))
				.andExpect(model().attribute("reservaActividad", hasProperty("precioFinal", is(100))))
				.andExpect(view().name("reservaActividad/reservaActividadDetails"));
	}
	
}
