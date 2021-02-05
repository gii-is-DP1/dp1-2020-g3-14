package org.springframework.samples.petclinic.web;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
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
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers=UserController.class,
excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = WebSecurityConfigurer.class),
excludeAutoConfiguration= SecurityConfiguration.class)
public class UserControllerTests {

	private static final String TEST_USERNAME = "enrmorvaz";
	
	@Autowired
	private UserController userController;

	@MockBean
	private UserService userService;
        
    
	@Autowired
	private MockMvc mockMvc;

	private User user;
	
	@BeforeEach
	void setup() {

		user = new User();
		user.setUsername(TEST_USERNAME);
		user.setPassword("prueba");
		user.setEnabled(true);
		user.setDni("20061859V");
		user.setTelefono("999666999");
		
		given(this.userService.findByUsername(TEST_USERNAME)).willReturn(user);

	}
	
	@WithMockUser(value = "spring")
	@Test
	void testInitUpdateUserForm() throws Exception {
		mockMvc.perform(get("/users/{username}/edit", TEST_USERNAME)).andExpect(status().isOk())
		.andExpect(model().attribute("user", hasProperty("username", is("Enrique"))))
		.andExpect(model().attribute("user", hasProperty("password", is("Contraseña0"))))
		.andExpect(model().attribute("user", hasProperty("telefono", is("666666666"))))
		.andExpect(model().attribute("user", hasProperty("dni", is("20061859V"))))
				.andExpect(view().name("users/createOrUpdateUserForm"));
	}


	@WithMockUser(value = "spring")
	@Test
	void testProcessUpdateFormSuccess() throws Exception {
		mockMvc.perform(post("/users/{username}/edit", TEST_USERNAME)
						.with(csrf())
						.param("username", "Enrique")
						.param("password", "Contraseña0")
						.param("telefono", "666666666")
						.param("dni", "20061859V"))
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/users/{username}"));
	}
	
}
