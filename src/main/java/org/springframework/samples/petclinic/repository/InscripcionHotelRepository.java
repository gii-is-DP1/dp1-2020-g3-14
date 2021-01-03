package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.model.InscripcionHotel;


public interface InscripcionHotelRepository extends JpaRepository<InscripcionHotel, Long> {
	
	//@Query("select u from inscripcionhoteles")
	//List<InscripcionHotel> findAll();
		
	InscripcionHotel findById(int id);
}
