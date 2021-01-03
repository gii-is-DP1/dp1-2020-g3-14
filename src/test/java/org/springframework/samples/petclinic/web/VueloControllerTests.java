package org.springframework.samples.petclinic.web;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.samples.petclinic.configuration.SecurityConfiguration;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.service.CompVuelosService;
import org.springframework.samples.petclinic.service.VueloService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=VueloController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class VueloControllerTests {
	
	private static final int TEST_VUELO_ID = 1;
	
	@Autowired
	private VueloController vueloController;
	
	@MockBean
	private VueloService vueloService;
	
	@MockBean
	private CompVuelosService compVuelosService;
    
	@Autowired
	private MockMvc mockMvc;

	private Vuelo vuelo;
	
	//Creamos el vuelo
	@BeforeEach
	void setup() {
		vuelo = new Vuelo();
		vuelo.setId(TEST_VUELO_ID);
		vuelo.setBilletes(2);
		vuelo.setDestino("Malaga");
		vuelo.setOrigen("Sevilla");
		vuelo.setPrecio(12);
		LocalDate fechaIda=LocalDate.of(2020, 10, 26);
		vuelo.setFechaIda(fechaIda);
		LocalDate fechaVuelta=LocalDate.of(2020, 11, 4);
		vuelo.setFechaVuelta(fechaVuelta);
		
		given(this.vueloService.findVueloById(TEST_VUELO_ID)).willReturn(vuelo);
		System.out.println(vuelo);
	}

	@WithMockUser(value = "spring")
        @Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/vuelos/new")).andExpect(status().isOk()).andExpect(model().attributeExists("vuelos"))
				.andExpect(view().name("vuelos/createOrUpdateVueloForm"));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/vuelos/new").param("billetes", "2")
							.with(csrf())
							.param("destino", "Malaga")
							.param("origen", "Sevilla")
							.param("precio", "12")
							.param("fechaIda", "2020/10/26")
							.param("fechaVuelta", "2020/11/04"))
				.andExpect(status().is3xxRedirection());
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormHasErrors() throws Exception {
		mockMvc.perform(post("/vuelos/new")
							.with(csrf())
							.param("billetes", "3")
							.param("destino", "")
							.param("origen", "Sevilla")
							.param("precio", "24")
							.param("fechaIda", "2020/10/26")
							.param("fechaVuelta", "2020/11/04"))
				.andExpect(status().isOk())
				.andExpect(model().attributeHasErrors("vuelo"))
				.andExpect(model().attributeHasFieldErrors("vuelo", "destino"))
				.andExpect(view().name("vuelos/createOrUpdateVueloForm"));
	}
}
