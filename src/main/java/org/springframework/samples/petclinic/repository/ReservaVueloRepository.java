package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.ReservaVuelo;

public interface ReservaVueloRepository extends JpaRepository<ReservaVuelo, Integer> {

	ReservaVuelo findById(int id);
	@Query("select v from ReservaVuelo v where v.user.username like %?1")
	Collection<ReservaVuelo> findReservaVueloByUserLike(String username);
	
	
	
}



