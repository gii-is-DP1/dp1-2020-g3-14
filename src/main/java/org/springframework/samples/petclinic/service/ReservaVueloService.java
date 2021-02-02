package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.repository.ReservaVueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaVueloService {

	private ReservaVueloRepository reservaVueloRepository;
	
	@Autowired
	public ReservaVueloService(ReservaVueloRepository reservaVueloRepository) {
		this.reservaVueloRepository = reservaVueloRepository;
	}
	
	@Transactional
	public void saveReservaVuelo(ReservaVuelo reserva) throws DataAccessException {
		reservaVueloRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReservaVuelo(ReservaVuelo reserva) throws DataAccessException {
		reservaVueloRepository.delete(reserva);                
	}

	@Transactional(readOnly = true)
	public ReservaVuelo findReservaVueloById(int id) throws DataAccessException {
		return reservaVueloRepository.findById(id);
	}
	
	@Transactional(readOnly = true)
	public Collection<ReservaVuelo> buscarReservaVuelo(String username) throws DataAccessException {
		return reservaVueloRepository.findReservaVueloByUserLike(username);                
	}
	
//	@Transactional(readOnly = true)
//	public Collection<ReservaHabitacion> findByUser(String username) throws DataAccessException {
//		return reservaHabitacionRepository.findByUserLike(username);
//	}
}
