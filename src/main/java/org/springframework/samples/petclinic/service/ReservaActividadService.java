package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.repository.ReservaActividadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaActividadService {

	private ReservaActividadRepository reservaActividadRepository;
	
	@Autowired
	public ReservaActividadService(ReservaActividadRepository reservaActividadRepository) {
		this.reservaActividadRepository = reservaActividadRepository;
	}
	
	@Transactional
	public void saveReservaActividad(ReservaActividad reserva) throws DataAccessException {
		reservaActividadRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReservaActividad(ReservaActividad reserva) throws DataAccessException {
		reservaActividadRepository.delete(reserva);                
	}

	@Transactional(readOnly = true)
	public ReservaActividad findReservaActividadById(int id) throws DataAccessException {
		return reservaActividadRepository.findById(id);
	}
	
//	@Transactional(readOnly = true)
//	public Collection<ReservaHabitacion> findByUser(String username) throws DataAccessException {
//		return reservaHabitacionRepository.findByUserLike(username);
//	}
}
