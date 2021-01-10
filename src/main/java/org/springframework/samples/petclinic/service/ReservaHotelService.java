package org.springframework.samples.petclinic.service;

import java.time.LocalDate;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.User;
import org.springframework.samples.petclinic.repository.ReservaHotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service

public class ReservaHotelService {
	

	private ReservaHotelRepository reservaHotelRepository;
	
	@Autowired
	public ReservaHotelService(ReservaHotelRepository reservaHotelRepository) {
		this.reservaHotelRepository = reservaHotelRepository;
	}
	
	
	
	
	//Añade y elimina del repositorio 
	@Transactional
	public void saveReserva(ReservaHotel reserva) throws DataAccessException {
		reservaHotelRepository.save(reserva);                
	}
	
	@Transactional
	public void deleteReserva(ReservaHotel reserva) throws DataAccessException {
		reservaHotelRepository.delete(reserva);                
	}
	
	
	//Buscame por id de reserva (que se genera solo el valor en la entidad), la reserva en concreto
	
	@Transactional(readOnly = true)
	public ReservaHotel findReservaById(int id) throws DataAccessException {
		return reservaHotelRepository.findReservaById(id);
	}
	
	//Buscame por fecha de reserva (que se genera solo el valor en la entidad), la reserva en concreto
	
	@Transactional(readOnly = true)
	public Collection<ReservaHotel> findByFecha(LocalDate fechita) throws DataAccessException {
		return reservaHotelRepository.findByFecha(fechita);
	}
	//Buscame por usuario de reserva (que se genera solo el valor en la entidad), las reservas en concreto
	
	@Transactional(readOnly = true)
	public Collection<ReservaHotel> findByUser(User user) throws DataAccessException {
		return reservaHotelRepository.findByUser(user);
	}


	
}
