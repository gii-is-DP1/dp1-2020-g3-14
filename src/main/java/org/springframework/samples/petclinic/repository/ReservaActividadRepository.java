package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.ReservaHabitacion;

public interface ReservaActividadRepository extends JpaRepository<ReservaActividad, Integer>{

	ReservaActividad findById(int id);
}
