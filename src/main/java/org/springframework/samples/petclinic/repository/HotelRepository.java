package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	@Query("select u from Hotel u where u.nombre like %?1")
	Collection<Hotel> findByNombreLike(String nombre);
	
	@Query("select u from Hotel u where u.provincia like %?1")
	Collection<Hotel> findByProvinciaLike(String provincia);
	
	@Query(value = "SELECT DISTINCT provincia FROM Hoteles", nativeQuery = true)
	public Collection<String> findProvincias();
	
	Hotel findById(int id);
}
