package org.springframework.samples.petclinic.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.User;



public interface ReservaHotelRepository extends CrudRepository<ReservaHotel, Integer>{
	
	//Por id
	
	@Query(value="SELECT * FROM reservasHotel WHERE id LIKE :id%", nativeQuery = true)
	public ReservaHotel findReservaById(@Param("id") int id);
	
	//Por fecha
	
	@Query(value = "SELECT * FROM reservasHotel WHERE fecha LIKE :fecha%", nativeQuery = true)
	public Collection<ReservaHotel> findByFecha(@Param("fecha") LocalDate fecha);
	
	// Por usuario
	
	@Query(value = "SELECT * FROM reservasHotel WHERE reservasHotel.user LIKE :user%", nativeQuery = true)
	public Collection<ReservaHotel> findByUser(@Param("user") User user);
	
	
}
