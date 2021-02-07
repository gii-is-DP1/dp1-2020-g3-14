package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.repository.HabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionService {
	
	
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	public HabitacionService(HabitacionRepository habitacionRepository) {
		this.habitacionRepository = habitacionRepository;
	}
	
	@Transactional(readOnly = true)
	public Habitacion findHabitacionById(int id) throws DataAccessException {
		return habitacionRepository.findByNhabitacionLike(id);
	}
	
	@Transactional
	public void saveHabitacion(Habitacion habitacion) throws DataAccessException {
		habitacionRepository.save(habitacion);                
	}
	
	@Transactional
	public void deleteHabitacion(Habitacion habitacion) throws DataAccessException {
		habitacionRepository.delete(habitacion);            
	}

}
