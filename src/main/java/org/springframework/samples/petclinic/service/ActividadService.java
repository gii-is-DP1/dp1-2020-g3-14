package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.repository.ActividadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ActividadService {
	
	private ActividadRepository actividadRepository;
	
	@Autowired
	public ActividadService(ActividadRepository actividadRepository) {
		this.actividadRepository = actividadRepository;
	}
	
	@Transactional(readOnly = true)
	public Actividad findActividadById(int id) throws DataAccessException {
		return actividadRepository.findById(id);
	}

	@Transactional
	public void saveActividad(Actividad actividad) throws DataAccessException {
		actividadRepository.save(actividad);                
	}

	@Transactional(readOnly = true)
	public Collection<Actividad> findByNombre(String nombre) throws DataAccessException {
		return actividadRepository.findByNombreLike(nombre);
	}
}
