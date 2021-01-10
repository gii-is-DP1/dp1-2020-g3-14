package org.springframework.samples.petclinic.web;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.service.ReservaActividadService;
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

public class ReservaActividadHistorialController {

	
	private final ReservaActividadService reservaActividadService;
	private final UserService userService;
	
	@Autowired
	public ReservaActividadHistorialController(final ReservaActividadService reservaActividadService, final UserService userService) {
		this.reservaActividadService = reservaActividadService;
		this.userService = userService;
	}

	// LISTADO DE RESERVASHOTEL
	// ------------------------------------------------------------------

		@GetMapping(value = "/reservas")
		public String processFindForm(final ReservaActividad reservaActividad,
				final User user, final BindingResult result, final Map<String, Object> model) {

			//User userLog = userService.findByUsername(user.getUsername());
			Collection<ReservaActividad> reservasActividadusuario = this.reservaActividadService.findByUser(user);

			if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream().map(x -> x.toString())
					.anyMatch(x -> x.equals("owner"))) {

				Stream<ReservaActividad> results = reservasActividadusuario.stream();
				results = filtroFecha(results);
				model.put("selections", results.collect(Collectors.toList()));

			} else if (SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
					
					.map(x -> x.toString()).anyMatch(x -> x.equals("user"))) {
				Stream<ReservaActividad> results = reservasActividadusuario.stream();
				results = filtroEsNombreUsuario(results);
				results = filtroFecha(results);
				model.put("selections", results.collect(Collectors.toList()));

			}

			return "reservas/reservasActividad";

		}
	
	
	
	
	
	// MOSTRADO DE ReservaActividad
			// -----------------------------------------------------------------

			@GetMapping("/reservasActividad/{ReservaActividadId}")
			public ModelAndView showReservaActividad(@PathVariable("ReservaActividadId") final int ReservaActividadId) {
				ModelAndView mav = new ModelAndView("reservasActividad/ReservaActividadDetails");
				mav.addObject(this.reservaActividadService.findReservaById(ReservaActividadId));
				return mav;
			}
			
				
	// Metodos auxiliares
			//Filtros para futura visualizacion

			private Stream<ReservaActividad> filtroEsNombreUsuario(Stream<ReservaActividad> str) {
				Stream<ReservaActividad> result = str.filter(x -> x.getUser().equals(userService.findUser(x.getUser().getUsername())));
				return result;
			}

			private Stream<ReservaActividad> filtroFecha(Stream<ReservaActividad> str) {
				Stream<ReservaActividad> result = str.filter(x -> x.getFecha().isAfter(LocalDate.now()));
				return result;
			}

			
}
