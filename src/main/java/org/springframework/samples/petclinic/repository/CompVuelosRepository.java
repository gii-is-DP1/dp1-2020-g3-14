package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.CompVuelos;


public interface CompVuelosRepository extends JpaRepository<CompVuelos, Integer>  {
		
	@Query("select c from CompVuelos c where c.nombre like %?1")
	Collection<CompVuelos> findByNombreLike(String nombre);

	
	CompVuelos findById(int id) throws DataAccessException;;
}
