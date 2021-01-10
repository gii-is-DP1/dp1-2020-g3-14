package org.springframework.samples.petclinic.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.User;
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
	
	
	//Añade y elimina del repositorio 

	@Transactional
	public void saveReserva(ReservaActividad reserva) throws DataAccessException {
		reservaActividadRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReserva(ReservaActividad reserva) throws DataAccessException {
		reservaActividadRepository.delete(reserva);                
	}
	
	
	//Buscame por id de reserva (que se genera solo el valor en la entidad), la reserva en concreto
	
		@Transactional(readOnly = true)
		public ReservaActividad findReservaById(int id) throws DataAccessException {
			return reservaActividadRepository.findReservaById(id);
		}
	
	//Buscame por nombre de actividad (que se genera solo el valor en la entidad), la reserva en concreto
		
		@Transactional(readOnly = true)
		public Collection<ReservaActividad> findByNombre(String nombreActividad) throws DataAccessException {
			return reservaActividadRepository.findByNombre(nombreActividad);
		}
		
	//Buscame por usuario de reserva (que se genera solo el valor en la entidad), las reservas en concreto
		
		@Transactional(readOnly = true)
		public Collection<ReservaActividad> findByUser(User user) throws DataAccessException {
			return reservaActividadRepository.findByUser(user);
		}

	
	
	
	
	
	
	
	
	
	
	
	
}
