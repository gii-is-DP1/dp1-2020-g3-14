package org.springframework.samples.petclinic.service;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaHabitacion;
import org.springframework.samples.petclinic.repository.ReservaHabitacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaHabitacionService {

	private ReservaHabitacionRepository reservaHabitacionRepository;
	
	@Autowired
	public ReservaHabitacionService(ReservaHabitacionRepository reservaHabitacionRepository) {
		this.reservaHabitacionRepository = reservaHabitacionRepository;
	}
	
	@Transactional
	public void saveReservaHabitacion(ReservaHabitacion reserva) throws DataAccessException {
		reservaHabitacionRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReservaHabitacion(ReservaHabitacion reserva) throws DataAccessException {
		reservaHabitacionRepository.delete(reserva);                
	}

	@Transactional(readOnly = true)
	public ReservaHabitacion findReservaHabitacionById(int id) throws DataAccessException {
		return reservaHabitacionRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<ReservaHabitacion> buscarReservaHabitacion(String username) throws DataAccessException {
		return reservaHabitacionRepository.findReservaHabitacionByUserLike(username);                
	}
	
//	@Transactional(readOnly = true)
//	public Collection<ReservaHabitacion> findByUser(String username) throws DataAccessException {
//		return reservaHabitacionRepository.findByUserLike(username);
//	}
}
