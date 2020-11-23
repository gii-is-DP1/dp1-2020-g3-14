package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.Actividad;

public interface ActividadRepository extends Repository<Actividad, Integer>  {
	
	void save(Actividad actividad) throws DataAccessException;
	
	@Query(value = "SELECT DISTINCT * FROM Actividades WHERE nombre LIKE :nombre%", nativeQuery = true)
	public Collection<Actividad> findByNombre(String nombre);

	public Actividad findById(Integer id);
}
