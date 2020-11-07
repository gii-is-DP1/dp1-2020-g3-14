package org.springframework.samples.petclinic.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.service.AgenActService;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedAgenActNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AgenActController {
	
	private static final String VIEWS_AGENACTS_CREATE_OR_UPDATE_FORM = "agenacts/createOrUpdateAgenActForm";
	private final AgenActService agenActService;
	
	@Autowired
	public AgenActController(AgenActService agenActService) {
			this.agenActService = agenActService;
   	}
	
	/*@ModelAttribute("agenAct")
	public AgenAct findAgenAct(@PathVariable("agenactId") int agenactId) {
		return this.agenActService.findAgenActById(agenactId);
	}*/

	@GetMapping(value = "/agenacts/new")
	public String initCreationForm(AgenAct agenAct, ModelMap model) {
		model.put("agenacts", agenAct);
		return VIEWS_AGENACTS_CREATE_OR_UPDATE_FORM;
	}
	
	@PostMapping(value = "/agenacts/new")
	public String processCreationForm(AgenAct agenAct, BindingResult result, ModelMap model) {		
		if (result.hasErrors()) {
			model.put("agenacts", agenAct);
			return VIEWS_AGENACTS_CREATE_OR_UPDATE_FORM;
		}
		else {
                    try{
                    	
                    	this.agenActService.saveAgenAct(agenAct);
                    }catch(DuplicatedAgenActNameException ex){
                        result.rejectValue("name", "duplicate", "already exists");
                        return VIEWS_AGENACTS_CREATE_OR_UPDATE_FORM;
                    }
                    return "redirect:/agenacts/{agenactId}";
		}
	}
	
	@GetMapping(value = "/agenacts/{agenactId}/edit")
	public String initUpdateForm(@PathVariable("agenactId") int agenActId, ModelMap model) {
		AgenAct agenAct = this.agenActService.findAgenActById(agenActId);
		model.put("agenacts", agenAct);
		return VIEWS_AGENACTS_CREATE_OR_UPDATE_FORM;
	}
	
	@RequestMapping(value = "/agenacts/find",method = RequestMethod.GET)
	public String initFindForm(Map<String, Object> model) {
		model.put("agenacts", new AgenAct());
		return "agenacts/findAgenActs";
	}
	
	
	@GetMapping(value = "/agenacts")
	public String processFindForm(AgenAct agenact, BindingResult result, Map<String, Object> model) {

		// allow parameterless GET request for /owners to return all records
		if (agenact.getNombre() == null) {
			agenact.setNombre(""); // empty string signifies broadest possible search
		}

		// find owners by last name
		Collection<AgenAct> results = this.agenActService.findByNombre(agenact.getNombre());
		if (results.isEmpty()) {
			// no owners found
			result.rejectValue("nombre", "notFound", "not found");
			return "agenacts/findAgenActs";
		}
		else if (results.size() == 1) {
			// 1 owner found
			agenact = results.iterator().next();
			return "redirect:/agenacts/" + agenact.getId();
		}
		else {
			// multiple owners found
			model.put("selections", results);
			return "agenacts/agenActsList";
		}
	}
	
}
