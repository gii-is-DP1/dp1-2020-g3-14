package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.ReservaActividadService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/actividades/{actividadId}")



public class ReservaActividadController {
	private ReservaActividadService reservaActividadService;
	private static final String VIEWS_RESERVAACTIVIDAD_CREATE_FORM = "reservaActividades/createReservaActividadForm";
	
	
	
	@Autowired
	public ReservaActividadController(final ReservaActividadService reservaActividadService ) {
		this.reservaActividadService = reservaActividadService;
		
	}
	
	
	//Preparacion de creacion de reserva, direccionamiento a formulario
		@GetMapping(value = "/reservaActividades/new")
		public String initCreationForm(Map<String, Object> model) {
			ReservaActividad reservaActividad = new ReservaActividad();

			model.put("reservasActividad", reservaActividad);
			return VIEWS_RESERVAACTIVIDAD_CREATE_FORM;
		}

	
		
		//Te rellena la entidad con los datos del formulario
			//Falta el parametro USUARIO
		
		@PostMapping(value = "/reservaActividades/new")
		public String processCreationForm(@PathVariable("actividadId") final int actividadId, 
				@PathVariable("username") final User username,
				@Valid final ReservaActividad reservaActividad, final BindingResult result) {

			if (result.hasErrors()) {
				return VIEWS_RESERVAACTIVIDAD_CREATE_FORM;
			} else {
				
				Actividad actividad = ActividadService.findActividadById(actividadId);
				User username2 = UserService.findByUsername(username.getUsername());
				reservaActividad.setActividad(actividad);
				reservaActividad.setUser(username2);


				this.reservaActividadService.saveReserva(reservaActividad);
				
				//Queda profesional volver a lista de hoteles
					//Se puede añadir vista de exito o algo asi.
				return "/actividades";
			}
		}

	
	
	
}
