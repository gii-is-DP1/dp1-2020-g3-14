package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HotelController {
	
	private static final String VIEWS_HOTELES_CREATE_OR_UPDATE_FORM = "hoteles/createOrUpdateHotelForm";
	private final HotelService hotelService;

	@Autowired
	public HotelController(HotelService hotelService) {
			this.hotelService = hotelService;
   	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping(value = "/hoteles/new")
	public String initCreationForm(Map<String, Object> model) {
		Hotel hotel = new Hotel();
		model.put("hoteles", hotel);
		return VIEWS_HOTELES_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/hoteles/new")
	public String processCreationForm(@Valid Hotel hotel, BindingResult result) {		
		if (result.hasErrors()) {
			return VIEWS_HOTELES_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.hotelService.saveHotel(hotel);
            return "redirect:/hoteles/{hotelId}";
		}
	}
	@GetMapping(value = "/hoteles/{hotelId}/edit")
	public String initUpdateForm(@PathVariable("hotelId") int hotelId, ModelMap model) {
		Hotel hotel = this.hotelService.findHotelById(hotelId);
		model.put("hoteles",hotel);
		return VIEWS_HOTELES_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/hoteles/{hotelId}/edit")
	public String processUpdateAgenActForm(@Valid Hotel hotel, BindingResult result,
			@PathVariable("hotelId") int hotelId,ModelMap model) {
		if (result.hasErrors()) {
			model.put("hoteles",hotel);
			return VIEWS_HOTELES_CREATE_OR_UPDATE_FORM;
		}
		else {
			hotel.setId(hotelId);			
			this.hotelService.saveHotel(hotel);
			return "redirect:/hoteles/{hotelId}";
		}
	}
	
	@GetMapping(value = "/hoteles/find")
	public String initFindForm(Map<String, Object> model) {
		model.put("hoteles", new Hotel()); 
		return "hoteles/findHoteles";
	}
	
	@GetMapping(value = "/hoteles")
	public String processFindForm(Hotel hotel, BindingResult result, Map<String, Object> model) {

		if (hotel.getNombre() == null && hotel.getProvincia() == null) {
			hotel.setNombre("");
			hotel.setProvincia("");// empty string signifies broadest possible search
		}

		Collection<Hotel> results = this.hotelService.findByNombre(hotel.getNombre());
		Collection<Hotel> resultsP = this.hotelService.findByProvincia(hotel.getProvincia());
		if(hotel.getNombre()!= null && hotel.getProvincia()==null) {
		
			if (results.isEmpty()) {
				result.rejectValue("nombre", "notFound", "not found");
				return "hoteles/findHoteles";
			}
			else if (results.size() == 1) {
				hotel = results.iterator().next();
				return "redirect:/hoteles/" + hotel.getId();
			}
			else {
				model.put("selections", results);
				return "hoteles/hotelesList";
			}

			
		}else if(hotel.getProvincia() != null && hotel.getNombre()==null) {
			if (resultsP.isEmpty()) {
				result.rejectValue("provincia", "notFound", "not found");
				return "hoteles/findHoteles";
			}
			else if (resultsP.size() == 1) {
				hotel = resultsP.iterator().next();
				return "redirect:/hoteles/" + hotel.getId();
			}
			else {
				model.put("selections", results);
				return "hoteles/hotelesList";
			}

		}
		return null;
			
	}


}
