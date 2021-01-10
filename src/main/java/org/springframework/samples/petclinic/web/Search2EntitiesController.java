package org.springframework.samples.petclinic.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.samples.petclinic.service.VueloService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class Search2EntitiesController {
	
	private final HotelService hotelService;
	private final VueloService vueloService;
	
	@Autowired
	public Search2EntitiesController(HotelService hotelService, VueloService vueloService) {
			this.hotelService = hotelService;
			this.vueloService = vueloService;
   	}
	
	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping(value = "/search/find")
	public String initFindEntitiesForm(Map<String, Object> model) {
		model.put("hotel", new Hotel()); 
		return "search/findEntities";
	}
	
	@GetMapping(value = "/search")
	public String processFindEntitiesForm(Hotel hotel, BindingResult result, Map<String, Object> model) {
		

		if (hotel.getProvincia() == null) {
			hotel.setProvincia(""); // empty string signifies broadest possible search
		}

		Collection<Hotel> resultsH = this.hotelService.findByProvincia(hotel.getProvincia());
		List<Vuelo> resultsV = this.vueloService.findAllDestinos();
		List<Vuelo> vuelos = new ArrayList<Vuelo>();
		
		if (resultsH.isEmpty()) {
				result.rejectValue("provincia", "notFound", "not found");
				return "search/notFound";
			}
		else {
				model.put("selectionsH", resultsH);
				for(int i=0; i<resultsV.size(); i++) {
					Vuelo current = resultsV.get(i);
					if(hotel.getProvincia().equals("")){
						vuelos.add(current);
					} else if(hotel.getProvincia().equals(current.getDestino())) {
						vuelos.add(current);
					}
				}
				model.put("selectionsV", vuelos);
				return "search/entitiesList";
		}
	}

}
