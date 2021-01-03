package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.ReservaVueloRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service

public class ReservaVueloService {
	

	private ReservaVueloRepository reservaVueloRepository;
	
	@Autowired
	public ReservaVueloService(ReservaVueloRepository reservaRepository) {
		this.reservaVueloRepository = reservaRepository;
	}
	
	
	
	
	
	//Añade y elimina del repositorio 
	@Transactional
	public void saveReserva(ReservaVuelo reserva) throws DataAccessException {
		reservaVueloRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReserva(ReservaVuelo reserva) throws DataAccessException {
		reservaVueloRepository.delete(reserva);                
	}
	
	
	//Buscame por id de reserva (que se genera solo el valor en la entidad), la reserva en concreto
	
	@Transactional(readOnly = true)
	public ReservaVuelo findReservaById(int id) throws DataAccessException {
		return reservaVueloRepository.findReservaById(id);
	}
	
	//Buscame por fecha de reserva, la reserva en concreto
	
	@Transactional(readOnly = true)
	public Collection<ReservaVuelo> findByFecha(LocalDate fechita) throws DataAccessException {
		return reservaVueloRepository.findByFecha(fechita);
	}
	
	//Buscame por usuario de reserva, las reservas en concreto
	
		@Transactional(readOnly = true)
	public Collection<ReservaVuelo> findByUser(User user) throws DataAccessException {
			return reservaVueloRepository.findByUser(user);
	
		}
	
	
	
	
	

}
