package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

import org.springframework.samples.petclinic.model.Reserva;

import org.springframework.samples.petclinic.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service

public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepo;
	
	
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepo = reservaRepository;
	}
	//Buscame por id de reserva (que se genera solo el valor en la entidad), la reserva en concreto
	
	@Transactional(readOnly = true)
	public Reserva findReservaById(int id) throws DataAccessException {
		return reservaRepo.findById(id);
	}
	
}
