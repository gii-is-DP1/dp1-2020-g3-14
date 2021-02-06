package org.springframework.samples.petclinic.web;

import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.service.HabitacionService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoteles/{hotelId}")
public class HabitacionController {
	
	private static final String VIEWS_HABITACION_CREATE_OR_UPDATE_FORM = "habitaciones/createOrUpdateHabitacionForm";
	
	private final HabitacionService habitacionService;
	private final HotelService hotelService;

	@Autowired
	public HabitacionController(HabitacionService habitacionService,HotelService hotelService) {
			this.habitacionService = habitacionService;
			this.hotelService= hotelService;
   	}
	
	@GetMapping(value = "/habitaciones/new")
	public String initCreationForm(Map<String, Object> model) {
		Habitacion habitacion = new Habitacion();
		model.put("habitacion", habitacion);
		return VIEWS_HABITACION_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/habitaciones/new")
	public String processCreationForm(@PathVariable("hotelId") int hotelId, @Valid Habitacion habitacion, BindingResult result, Map<String, Object> model) {		
		Hotel hotel = this.hotelService.findHotelById(hotelId);
		if (result.hasErrors()) {
			model.put("habitacion", habitacion);
			return VIEWS_HABITACION_CREATE_OR_UPDATE_FORM;
		}
		else {
			habitacion.setHotel(hotel);
			this.habitacionService.saveHabitacion(habitacion);
			return "redirect:/hoteles/"+hotelId;
		}
	}
	
	@ModelAttribute("hotel")
	public Hotel findHotel(@PathVariable("hotelId") int hotelId) {
		return this.hotelService.findHotelById(hotelId);
	}
	
	@InitBinder("hotel")
	public void initHotelBinder(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

}
