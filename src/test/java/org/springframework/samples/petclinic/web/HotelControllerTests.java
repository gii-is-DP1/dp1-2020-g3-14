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
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=HotelController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class HotelControllerTests {
	
	private static final int TEST_HOTEL_ID = 1;
	
	@Autowired
	private HotelController hotelController;

	@MockBean
	private HotelService hotelService;
        
    
	@Autowired
	private MockMvc mockMvc;

	private Hotel hotelazo;
	
	//Creamos el hotel
	@BeforeEach
	void setup() {

		hotelazo = new Hotel();
		hotelazo.setId(TEST_HOTEL_ID);
		hotelazo.setNombre("Hotelazo");
		hotelazo.setDireccion("Calle normal");
		hotelazo.setProvincia("Cadiz");
		hotelazo.setEstrellas(5);
		hotelazo.setPrecio("45210");
		hotelazo.setTelefono("945122241");
		//Deberá devolver el hotel
		given(this.hotelService.findHotelById(TEST_HOTEL_ID)).willReturn(hotelazo);

	}
	

	@WithMockUser(value = "spring")
        @Test
	void testInitCreationForm() throws Exception {
		mockMvc.perform(get("/hoteles/new")).andExpect(status().isOk()).andExpect(model().attributeExists("hotel"))
				.andExpect(view().name("hoteles/createOrUpdateHotelForm"));
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormSuccess() throws Exception {
		mockMvc.perform(post("/hoteles/new").param("nombre", "Lujo")
							.with(csrf())
							.param("direccion", "123 Prueba Street")
							.param("estrellas", "4")
							.param("provincia", "Malaga")
							.param("telefono", "013167638")
							.param("precio", "4175"))
				.andExpect(status().is3xxRedirection());
	}

	@WithMockUser(value = "spring")
        @Test
	void testProcessCreationFormHasErrors() throws Exception {
		mockMvc.perform(post("/hoteles/new")
							.with(csrf())
							.param("nombre", "Joe")
							.param("direccion", "123 Prueba Street")
							.param("estrellas", "4")
							.param("provincia", "Malaga")
							.param("telefono", "013167638"))
				.andExpect(status().isOk())
				.andExpect(model().attributeHasErrors("hotel"))
				.andExpect(model().attributeHasFieldErrors("hotel", "precio"))
				.andExpect(view().name("hoteles/createOrUpdateHotelForm"));
	}
}
