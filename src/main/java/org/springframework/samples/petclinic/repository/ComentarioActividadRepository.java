package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.ComentarioActividad;


public interface ComentarioActividadRepository extends JpaRepository<ComentarioActividad, String>{

	ComentarioActividad findById(int id) throws DataAccessException;
}
