package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ReservaHotelService;
import org.springframework.samples.petclinic.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/{userId}/reservas")
public class ReservaHotelHistorialController {

	private final ReservaHotelService reservaHotelService;
	private final UserService userService;
	
	@Autowired
	public ReservaHotelHistorialController(final ReservaHotelService reservaHotelService, final UserService userService) {
		this.reservaHotelService = reservaHotelService;
		this.userService = userService;
	}

	// LISTADO DE RESERVASHOTEL
	// ------------------------------------------------------------------

		@GetMapping(value = "/reservas")
		public String processFindForm(final ReservaHotel reservaHotel,
				final User user, final BindingResult result, final Map<String, Object> model) {

			//User userLog = userService.findByUsername(user.getUsername());
			Collection<ReservaHotel> reservasHotelusuario = this.reservaHotelService.findByUser(user);

			if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(x -> x.toString())
					.anyMatch(x -> x.equals("owner"))) {

				Stream<ReservaHotel> results = reservasHotelusuario.stream();
				results = filtroFecha(results);
				model.put("selections", results.collect(Collectors.toList()));

			} else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
					
					.map(x -> x.toString()).anyMatch(x -> x.equals("user"))) {
				Stream<ReservaHotel> results = reservasHotelusuario.stream();
				results = filtroEsNombreUsuario(results);
				results = filtroFecha(results);
				model.put("selections", results.collect(Collectors.toList()));

			}

			return "reservas/reservasHotel";

		}

		// MOSTRADO DE ReservaHotel
		// -----------------------------------------------------------------

		@GetMapping("/reservasHotel/{ReservaHotelId}")
		public ModelAndView showReservaHotel(@PathVariable("ReservaHotelId") final int ReservaHotelId) {
			ModelAndView mav = new ModelAndView("reservasHotel/ReservaHotelDetails");
			mav.addObject(this.reservaHotelService.findReservaById(ReservaHotelId));
			return mav;
		}

		// Metodos auxiliares
		//Filtros para futura visualizacion

		private Stream<ReservaHotel> filtroEsNombreUsuario(Stream<ReservaHotel> str) {
			Stream<ReservaHotel> result = str.filter(x -> x.getUser().equals(userService.findUser(x.getUser().getUsername())));
			return result;
		}

		private Stream<ReservaHotel> filtroFecha(Stream<ReservaHotel> str) {
			Stream<ReservaHotel> result = str.filter(x -> x.getFecha().isAfter(LocalDate.now()));
			return result;
		}

		
}
