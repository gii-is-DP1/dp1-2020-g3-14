package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Hotel;


public interface HotelRepository extends CrudRepository<Hotel, Integer> {
	
	@Query(value = "SELECT DISTINCT * FROM Hoteles WHERE nombre LIKE :nombre%", nativeQuery = true)
	public Collection<Hotel> findByNombre(@Param("nombre") String nombre);
	
	@Query(value = "SELECT DISTINCT * FROM Hoteles WHERE provincia LIKE :provincia%", nativeQuery = true)
	public Collection<Hotel> findByProvincia(@Param("provincia") String provincia);
	
	@Query(value = "SELECT DISTINCT provincia FROM Hoteles", nativeQuery = true)
	public Collection<String> findProvincias();
	
	@Query(value="SELECT * FROM Hoteles WHERE id LIKE :id%", nativeQuery = true)
	public Hotel findById(@Param("id") int id);
	
}
