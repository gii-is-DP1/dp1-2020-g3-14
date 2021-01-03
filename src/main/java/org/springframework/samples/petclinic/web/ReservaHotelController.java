package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.HabitacionService;
import org.springframework.samples.petclinic.service.HotelService;
import org.springframework.samples.petclinic.service.ReservaHotelService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hoteles/{hotelId}/habitaciones/{habitacionId}")
public class ReservaHotelController {

	private ReservaHotelService reservaHotelService;
	private static final String VIEWS_RESERVAHOTEL_CREATE_FORM = "reservaHoteles/createRentalForm";
	
	@Autowired
	public ReservaHotelController(final ReservaHotelService reservaHotelService ) {
		this.reservaHotelService = reservaHotelService;
		
	}

	
	
	
	//Preparacion de creacion de reserva, direccionamiento a formulario
	@GetMapping(value = "/reservaHotel/new")
	public String initCreationForm(Map<String, Object> model) {
		ReservaHotel reservaHotel = new ReservaHotel();

		model.put("reservasHotel", reservaHotel);
		return VIEWS_RESERVAHOTEL_CREATE_FORM;
	}

	
	//Te rellena la entidad con los datos del formulario
		//Falta el parametro USUARIO
	@PostMapping(value = "/reservaHotel/new")
	public String processCreationForm(@PathVariable("habitacionId") final int habitacionId, 
			@PathVariable("hotelId") final int hotelId,
			@Valid final ReservaHotel reservaHotel, final BindingResult result) {

		if (result.hasErrors()) {
			return VIEWS_RESERVAHOTEL_CREATE_FORM;
		} else {
			
			Habitacion habitacion = HabitacionService.findHabitacionById(habitacionId);
			Hotel hotel = HotelService.findHotelById(hotelId);
			
			reservaHotel.setHotel(hotel);
			reservaHotel.setHabitacion(habitacion);
			


			this.reservaHotelService.saveReserva(reservaHotel);
			
			//Queda profesional volver a lista de hoteles
				//Se puede añadir vista de exito o algo asi.
			return "/hoteles";
		}
	}

	

}
