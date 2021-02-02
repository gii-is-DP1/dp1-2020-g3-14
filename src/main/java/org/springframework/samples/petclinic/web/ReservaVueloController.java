package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.ReservaActividadService;
import org.springframework.samples.petclinic.service.ReservaVueloService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.samples.petclinic.service.VueloService;
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
@RequestMapping("/vuelos/{vueloId}")
public class ReservaVueloController {

	private ReservaVueloService reservaVueloService;
	private VueloService vueloService;
	private UserService userService;
	private static final String VIEWS_RESERVAVUELO_CREATE_FORM = "reservaVuelo/createReservaVueloForm";
	
	@Autowired
	public ReservaVueloController(final ReservaVueloService reservaVueloService,final VueloService vueloService, final UserService userService) {
		this.reservaVueloService = reservaVueloService;
		this.vueloService=vueloService;
		this.userService= userService;
	}

	@GetMapping(value = "reservaVuelo/new")
	public String initCreationForm(Map<String, Object> model) {
		ReservaVuelo reservaVuelo = new ReservaVuelo();
		model.put("reservaVuelo", reservaVuelo);
		return VIEWS_RESERVAVUELO_CREATE_FORM;
	}

	@PostMapping(value = "reservaVuelo/new")
	public String processCreationForm(@PathVariable("vueloId") int vueloId,
			@Valid final ReservaVuelo reservaVuelo, final BindingResult result) {
		reservaVuelo.setFechaReserva(LocalDate.now());
		Vuelo v = this.vueloService.findVueloById(vueloId);
		System.out.println("============MENSAJES DE ERROR===============");
		System.out.println(result.getAllErrors());
		if (result.hasErrors()) {			
			return VIEWS_RESERVAVUELO_CREATE_FORM;
		} else {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails userDetails = null;
			if (principal instanceof UserDetails) {
				userDetails = (UserDetails) principal;
				}
			String userName = userDetails.getUsername();
			User user= this.userService.findByUsername(userName);
			Set<User> ls = v.getUsers();
			ls.add(user);
			v.setUsers(ls);
			reservaVuelo.setPrecioFinal(Integer.valueOf(v.getPrecio()*v.getBilletes()));
			reservaVuelo.setIda(v.getFechaIda());
			reservaVuelo.setVuelta(v.getFechaVuelta());
			reservaVuelo.setVuelo(v);
			reservaVuelo.setUser(user);
			this.reservaVueloService.saveReservaVuelo(reservaVuelo);
			return "redirect:"+reservaVuelo.getId();
		}
	}
	
	@GetMapping("reservaVuelo/{reservaVueloId}")
	public ModelAndView showReservaVuelo(@PathVariable("reservaVueloId") int reservaVueloId) {
		ModelAndView mav = new ModelAndView("reservaVuelo/reservaVueloDetails");
		mav.addObject("reservaVuelo", this.reservaVueloService.findReservaVueloById(reservaVueloId));
		return mav;
	}
}
