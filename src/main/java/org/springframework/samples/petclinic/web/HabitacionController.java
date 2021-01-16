package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.service.HabitacionService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoteles/{hotelId}")
public class HabitacionController {
	
	private final HabitacionService habitacionService;
	private final HotelService hotelService;

	@Autowired
	public HabitacionController(HabitacionService habitacionService,HotelService hotelService) {
			this.habitacionService = habitacionService;
			this.hotelService= hotelService;
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
