package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Habitacion;


public interface HabitacionRepository  extends Repository<Habitacion, Integer> {

	@Query(value="SELECT * FROM habitaciones WHERE nhabitacion LIKE :nhabitacion%", nativeQuery = true)
	public Habitacion findById(@Param("nhabitacion") int nhabitacion);
	
}
