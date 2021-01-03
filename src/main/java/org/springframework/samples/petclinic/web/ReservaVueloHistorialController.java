package org.springframework.samples.petclinic.web;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ReservaVueloService;
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
public class ReservaVueloHistorialController {

		private final ReservaVueloService reservaVueloService;
		private final UserService userService;
	
		
		@Autowired
		public ReservaVueloHistorialController(final ReservaVueloService reservaVueloService, final UserService userService) {
			this.reservaVueloService = reservaVueloService;
			this.userService = userService;
		}

		// LISTADO DE RESERVASVuelo
		// ------------------------------------------------------------------

			@GetMapping(value = "/reservas")
			public String processFindForm(final ReservaVuelo reservaVuelo,
					final User user, final BindingResult result, final Map<String, Object> model) {

				//User userLog = userService.findByUsername(user.getUsername());
				Collection<ReservaVuelo> reservasVuelousuario = this.reservaVueloService.findByUser(user);

				if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(x -> x.toString())
						.anyMatch(x -> x.equals("owner"))) {

					Stream<ReservaVuelo> results = reservasVuelousuario.stream();
					results = filtroFecha(results);
					model.put("selections", results.collect(Collectors.toList()));

				} else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
						
						.map(x -> x.toString()).anyMatch(x -> x.equals("user"))) {
					Stream<ReservaVuelo> results = reservasVuelousuario.stream();
					results = filtroEsNombreUsuario(results);
					results = filtroFecha(results);
					model.put("selections", results.collect(Collectors.toList()));

				}

				return "reservas/reservasVuelo";

			}

			// MOSTRADO DE ReservaVuelo
			// -----------------------------------------------------------------

			@GetMapping("/reservasVuelo/{ReservaVueloId}")
			public ModelAndView showReservaHotel(@PathVariable("ReservaVueloId") final int ReservaVueloId) {
				ModelAndView mav = new ModelAndView("reservasHotel/ReservaHotelDetails");
				mav.addObject(this.reservaVueloService.findReservaById(ReservaVueloId));
				return mav;
			}

			// Metodos auxiliares
			//Filtros para futura visualizacion

			private Stream<ReservaVuelo> filtroEsNombreUsuario(Stream<ReservaVuelo> str) {
				Stream<ReservaVuelo> result = str.filter(x -> x.getUser().equals(userService.findUser(x.getUser().getUsername())));
				return result;
			}

			private Stream<ReservaVuelo> filtroFecha(Stream<ReservaVuelo> str) {
				Stream<ReservaVuelo> result = str.filter(x -> x.getFecha().isAfter(LocalDate.now()));
				return result;
			}

			
	

}
