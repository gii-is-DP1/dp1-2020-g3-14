package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.service.VueloService;


import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.service.ReservaVueloService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/vuelos/{vueloId}")


public class ReservaVueloController {


		private ReservaVueloService reservaVueloService;
		private static final String VIEWS_RESERVAVUELO_CREATE_FORM = "reservaVuelos/createReservaVueloForm";
		
		@Autowired
		public ReservaVueloController(final ReservaVueloService reservaVueloService ) {
			this.reservaVueloService = reservaVueloService;
			
		}

		
		
		
		//Preparacion de creacion de reserva, direccionamiento a formulario
		@GetMapping(value = "/reservaVuelo/new")
		public String initCreationForm(Map<String, Object> model) {
			ReservaVuelo reservaVuelo = new ReservaVuelo();

			model.put("reservasVuelo", reservaVuelo);
			return VIEWS_RESERVAVUELO_CREATE_FORM;
		}

		
		//Te rellena la entidad con los datos del formulario
			//Falta el parametro USUARIO
		@PostMapping(value = "/reservaVuelo/new")
		public String processCreationForm(@PathVariable("vueloId") final int vueloId, 
				@PathVariable("username") final User username,
				@Valid final ReservaVuelo reservaVuelo, final BindingResult result) {

			if (result.hasErrors()) {
				return VIEWS_RESERVAVUELO_CREATE_FORM;
			} else {
				
				Vuelo vuelo = VueloService.findVueloById(vueloId);		
				User username2 = UserService.findByUsername(username.getUsername());
			
				
				
				reservaVuelo.setUser(username2);
				reservaVuelo.setVuelo(vuelo);
				
			
				this.reservaVueloService.saveReserva(reservaVuelo);
				
				//Queda profesional volver a lista de vuelos
					//Se puede añadir vista de exito o algo asi.
				return "/vuelos";
			}
		}

		

	

}
