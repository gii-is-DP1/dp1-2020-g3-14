package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.ReservaHabitacion;

public interface ReservaHabitacionRepository extends JpaRepository<ReservaHabitacion, Integer>{
	

	
	ReservaHabitacion findById(int id);
}
