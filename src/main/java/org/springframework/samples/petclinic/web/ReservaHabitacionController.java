package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import static java.time.temporal.ChronoUnit.DAYS;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.ReservaHabitacion;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.HabitacionService;
import org.springframework.samples.petclinic.service.ReservaHabitacionService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
	private HabitacionService habitacionService;
	private UserService userService;
	private static final String VIEWS_RESERVAHABITACION_CREATE_FORM = "reservaHabitacion/createReservaHabitacionForm";
	
	@Autowired
	public ReservaHabitacionController(final ReservaHabitacionService reservaHabitacionService,final HabitacionService habitacionService, final UserService userService) {
		this.reservaHabitacionService = reservaHabitacionService;
		this.habitacionService=habitacionService;
		this.userService= userService;
	}

	@GetMapping(value = "reservaHabitacion/new")
	public String initCreationForm(Map<String, Object> model) {
		ReservaHabitacion reservaHabitacion = new ReservaHabitacion();
		model.put("reservaHabitacion", reservaHabitacion);
		return VIEWS_RESERVAHABITACION_CREATE_FORM;
	}

	@PostMapping(value = "reservaHabitacion/new")
	public String processCreationForm(@PathVariable("nhabitacion") int nhabitacion,
			@Valid ReservaHabitacion reservaHabitacion, BindingResult result, Map<String, Object> model) {
		reservaHabitacion.setFechaReserva(LocalDate.now());
		if (result.hasErrors()) {
			model.put("reservaHabitacion", reservaHabitacion);
			return VIEWS_RESERVAHABITACION_CREATE_FORM;
		} else {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails userDetails = null;
			if (principal instanceof UserDetails) {
				userDetails = (UserDetails) principal;
				}
			String userName = userDetails.getUsername();
			User user= this.userService.findByUsername(userName);
			Habitacion h = this.habitacionService.findHabitacionByNhabitacion(nhabitacion);
			Set<User> ls = h.getUsers();
			ls.add(user);
			h.setUsers(ls);
			h.setDisponible(false);
			reservaHabitacion.setHabitacion(h);
			reservaHabitacion.setUser(user);
			LocalDate entrada = reservaHabitacion.getEntrada();
			LocalDate salida = reservaHabitacion.getSalida();
			Double dias = (double) DAYS.between(entrada, salida);
			Double precio = dias*h.getPrecio();
			reservaHabitacion.setPrecioFinal(precio);
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
