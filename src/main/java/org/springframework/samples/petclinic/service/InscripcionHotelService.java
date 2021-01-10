package org.springframework.samples.petclinic.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.InscripcionHotel;
import org.springframework.samples.petclinic.repository.HotelRepository;
import org.springframework.samples.petclinic.repository.InscripcionHotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InscripcionHotelService {
	
	private InscripcionHotelRepository inscripcionHotelRepository;
	
	@Autowired
	public InscripcionHotelService(InscripcionHotelRepository inscripcionHotelRepository) {
		this.inscripcionHotelRepository = inscripcionHotelRepository;
	}
	
	@Transactional(readOnly = true)
	public InscripcionHotel findInscripcionHotelById(int id) throws DataAccessException {
		return inscripcionHotelRepository.findById(id);
	}
	
	@Transactional
	public void saveInscripcionHotel(InscripcionHotel inscripcionHotel) throws DataAccessException {
		inscripcionHotelRepository.save(inscripcionHotel);                
	}

	public List<InscripcionHotel> findAll() throws DataAccessException {
		return inscripcionHotelRepository.findAll();
	}
	
}
