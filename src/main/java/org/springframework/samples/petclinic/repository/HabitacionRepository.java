package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Habitacion;

public interface HabitacionRepository  extends JpaRepository<Habitacion, Long> {

	@Query("select u from Habitacion u where u.nhabitacion like %?1")
	Habitacion findByNhabitacionLike(Integer nhabitacion);
}
