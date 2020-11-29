package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.CompVuelos;


public interface CompVuelosRepository extends Repository<CompVuelos, Integer>  {
	
	void save(CompVuelos compvuelos) throws DataAccessException;
	
	@Query(value = "SELECT DISTINCT * FROM CompVuelos WHERE nombre LIKE :nombre%", nativeQuery = true)
	public Collection<CompVuelos> findByNombre(@Param("nombre") String nombre);

	
	@Query(value="SELECT * FROM CompVuelos WHERE id LIKE :id%", nativeQuery = true)
	public CompVuelos findById(@Param("id") int id);
}
