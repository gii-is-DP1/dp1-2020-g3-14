package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Reserva;


public interface ReservaRepository extends CrudRepository<Reserva, Integer>{

	@Query(value="SELECT * FROM reservas WHERE id LIKE :id%", nativeQuery = true)
	public Reserva findById(@Param("id") int id);
	
}
