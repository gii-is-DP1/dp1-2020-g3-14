package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Vuelo;
import org.springframework.samples.petclinic.repository.VuelosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class VueloService {
	
	private VuelosRepository vueloRepository;
	
	@Autowired
	public VueloService(VuelosRepository vuelosRepository) {
		this.vueloRepository = vuelosRepository;
	}
	
	@Transactional(readOnly = true)
	public Vuelo findVueloById(int id) throws DataAccessException {
		return vueloRepository.findById(id);
	}

	@Transactional
	public void saveVuelo(Vuelo vuelo) throws DataAccessException {
		vueloRepository.save(vuelo);                
	}

	@Transactional(readOnly = true)
	public Collection<Vuelo> findByOrigen(String origen) throws DataAccessException {
		return vueloRepository.findByOrigenLike(origen);
	}
	
}
