package org.springframework.samples.petclinic.web;

import org.springframework.samples.petclinic.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.service.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vuelos/{vueloId}")
public class ReservaController {

	private final ReservaService reservaService;
	private final VueloService vueloService;
	
	
	@Autowired
	public ReservaController(ReservaService reservaService,VueloService vueloService) {
			this.reservaService = reservaService;
			this.vueloService= vueloService;
   	}
	
	@ModelAttribute("vuelo")
	public Vuelo findVuelo(@PathVariable("vueloId") int vueloId) {
		return this.vueloService.findVueloById(vueloId);
	}
	
	@InitBinder("vuelo")
	public void initVueloBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	
}
