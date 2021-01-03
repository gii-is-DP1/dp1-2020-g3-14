package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Habitacion;
import org.springframework.samples.petclinic.repository.HabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitacionService {
	
	
	private static HabitacionRepository habitacionRepository;
	
	@Autowired
	public HabitacionService(HabitacionRepository habitacionRepository) {
		this.habitacionRepository = habitacionRepository;
	}
	
	@Transactional(readOnly = true)
	public static Habitacion findHabitacionById(int id) throws DataAccessException {
		return habitacionRepository.findById(id);
	}
	

}
