package org.springframework.samples.petclinic.web;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ComentarioActividad;
import org.springframework.samples.petclinic.service.ActividadService;
import org.springframework.samples.petclinic.service.ComentarioActividadService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ComentarioActividadController {
	
	private static final String VIEWS_COMENTARIO_FORM = "actividades/createComentarioForm";
	private final ComentarioActividadService comentarioService;
	private final ActividadService actividadService;
	
	@Autowired
	public ComentarioActividadController(ComentarioActividadService comentarioService,ActividadService actividadService) {
			this.comentarioService = comentarioService;
			this.actividadService = actividadService;
   	}
	
	@ModelAttribute("actividad")
	public Actividad findActividad(@PathVariable("actividadId") int actividadId) {
		return this.actividadService.findActividadById(actividadId);
	}
	
	@InitBinder("actividad")
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}
	
	@GetMapping(value = "actividades/{actividadId}/comentarios/new")
	public String initCreationForm(Map<String, Object> model) {
		ComentarioActividad comentario = new ComentarioActividad();
		model.put("comentario", comentario);
		return VIEWS_COMENTARIO_FORM;
	}
	
	@PostMapping(value = "actividades/{actividadId}/comentarios/new")
	public String processCreationForm(@PathVariable("actividadId") int actividadId, @Valid ComentarioActividad comentario, BindingResult result) {		
		if (result.hasErrors()) {
			return VIEWS_COMENTARIO_FORM;
		}
		else {
			this.comentarioService.savec(actividadId, comentario);
            return "redirect:/actividades/"+actividadId;
		}
	}


}
