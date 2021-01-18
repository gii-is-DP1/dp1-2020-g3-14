package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.ReservaHabitacion;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ReservaHabitacionService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hoteles/{hotelId}/{nhabitacion}/")
public class ReservaHabitacionController {

	private ReservaHabitacionService reservaHabitacionService;
	private static final String VIEWS_RESERVAHABITACION_CREATE_FORM = "reservaHabitacion/createReservaHabitacionForm";
	
	@Autowired
	public ReservaHabitacionController(final ReservaHabitacionService reservaHabitacionService ) {
		this.reservaHabitacionService = reservaHabitacionService;
	}

	@GetMapping(value = "reservaHabitacion/new")
	public String initCreationForm(Map<String, Object> model) {
		ReservaHabitacion reservaHabitacion = new ReservaHabitacion();

		model.put("reservaHabitacion", reservaHabitacion);
		return VIEWS_RESERVAHABITACION_CREATE_FORM;
	}

	@PostMapping(value = "reservaHabitacion/new")
	public String processCreationForm(
			@Valid final ReservaHabitacion reservaHabitacion,@Valid final Habitacion habitacion,@Valid final User user, final BindingResult result) {
		reservaHabitacion.setFechaReserva(LocalDate.now());
		habitacion.getUsers().add(user);
		if (result.hasErrors()) {
			return VIEWS_RESERVAHABITACION_CREATE_FORM;
		} else {
			this.reservaHabitacionService.saveReservaHabitacion(reservaHabitacion);
			return "redirect:"+reservaHabitacion.getId();
		}
	}
	
	@GetMapping("reservaHabitacion/{reservaHabitacionId}")
	public ModelAndView showReservaHabitacion(@PathVariable("reservaHabitacionId") int reservaHabitacionId) {
		ModelAndView mav = new ModelAndView("reservaHabitacion/reservaHabitacionDetails");
		mav.addObject("reservaHabitacion", this.reservaHabitacionService.findReservaHabitacionById(reservaHabitacionId));
		return mav;
	}
}
