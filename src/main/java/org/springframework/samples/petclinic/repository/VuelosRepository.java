package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Vuelo;


public interface VuelosRepository extends Repository<Vuelo, Integer>  {
	
	void save(Vuelo vuelo) throws DataAccessException;
	
	@Query(value = "SELECT DISTINCT * FROM Vuelos WHERE origen LIKE :origen%", nativeQuery = true)
	public Collection<Vuelo> findByOrigen(@Param("origen") String origen);

	
	@Query(value="SELECT * FROM Vuelos WHERE id LIKE :id%", nativeQuery = true)
	public Vuelo findById(@Param("id") int id);
}
