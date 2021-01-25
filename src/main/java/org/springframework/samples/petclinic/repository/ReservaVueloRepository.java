package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.samples.petclinic.model.ReservaVuelo;



public interface ReservaVueloRepository extends JpaRepository<ReservaVuelo, Integer> {

	ReservaVuelo findById(int id);
	
	
	
}



