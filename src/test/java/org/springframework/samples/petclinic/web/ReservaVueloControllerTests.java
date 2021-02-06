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
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.samples.petclinic.service.ReservaActividadService;
import org.springframework.samples.petclinic.service.ReservaVueloService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.samples.petclinic.service.VueloService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=ReservaVueloController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class ReservaVueloControllerTests {
	
	private static final int TEST_RESERVAVUELO_ID = 1;
	
	@Autowired
	private ReservaVueloController reservaVueloController;

	@MockBean
	private ReservaVueloService reservaVueloService;
	@MockBean
	private VueloService vueloService;
	@MockBean
	private UserService userService;
    
	@Autowired
	private MockMvc mockMvc;

	
	private ReservaVuelo reservaVuelo;
	
	
	//Creamos la reserva
	@BeforeEach
	void setup() {

		reservaVuelo = new ReservaVuelo();
		reservaVuelo.setFechaReserva(LocalDate.now());
		reservaVuelo.setIda(LocalDate.of(2021, 4, 13));
		reservaVuelo.setVuelta(LocalDate.of(2021, 4, 17));
		reservaVuelo.setNumeroTarjeta("1111111111111111");;
		reservaVuelo.setCvc("333");
		reservaVuelo.setPrecioFinal(100);

		//Deberá devolver el hotel
		given(this.reservaVueloService.findReservaVueloById(TEST_RESERVAVUELO_ID)).willReturn(reservaVuelo);

	}
	

	@WithMockUser(value = "spring")
        @Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/vuelos/{vueloId}/reservaVuelo/new",1)).andExpect(status().isOk()).andExpect(model().attributeExists("reservaVuelo"))
				.andExpect(view().name("reservaVuelo/createReservaVueloForm"));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/vuelos/{vueloId}/reservaVuelo/new",1).param("fechaReserva", "2021/10/10")
							.with(csrf())
							.param("ida", "2021/10/13")
							.param("vuelta", "2021/10/17")
							.param("numeroTarjeta", "1111111111111111")
							.param("cvc", "333")
							.param("precioFinal", "100"))
				.andExpect(status().is2xxSuccessful());
	}
	
	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormHasErrors() throws Exception {
		mockMvc.perform(post("/vuelos/{vueloId}/reservaVuelo/new",1)
							.with(csrf())
							.param("fechaReserva", "2021/10/10")
							.param("ida", "2021/10/13")
							.param("vuelta", "2021/10/17")
							.param("numeroTarjeta", "")
							.param("cvc", "333")
							.param("precioFinal", "100"))

            .andExpect(model().attributeHasErrors("reservaVuelo")).andExpect(status().isOk())
            .andExpect(view().name("reservaVuelo/createReservaVueloForm"));
	}
	
     @WithMockUser(value = "spring")
	@Test
	void testShowReservaVuelo() throws Exception {
		mockMvc.perform(get("/vuelos/{vueloId}/reservaVuelo/{reservaVueloId}",1, TEST_RESERVAVUELO_ID)).andExpect(status().isOk())
				.andExpect(model().attribute("reservaVuelo", hasProperty("fechaReserva", is(LocalDate.now()))))
				.andExpect(model().attribute("reservaVuelo", hasProperty("ida", is(LocalDate.of(2021, 4, 13)))))
				.andExpect(model().attribute("reservaVuelo", hasProperty("vuelta",is(LocalDate.of(2021, 4, 17)))))
				.andExpect(model().attribute("reservaVuelo", hasProperty("numeroTarjeta", is("1111111111111111"))))
				.andExpect(model().attribute("reservaVuelo", hasProperty("cvc", is("333"))))
				.andExpect(model().attribute("reservaVuelo", hasProperty("precioFinal", is(100))))
				.andExpect(view().name("reservaVuelo/reservaVueloDetails"));
	}
	
	
}
