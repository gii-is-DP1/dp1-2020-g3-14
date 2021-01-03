package org.springframework.samples.petclinic.repository;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.ReservaHotel;
import org.springframework.samples.petclinic.model.ReservaVuelo;
import org.springframework.samples.petclinic.model.User;


public interface ReservaVueloRepository extends CrudRepository<ReservaVuelo, Integer>{
	
	//Por id
	
	@Query(value="SELECT * FROM reservasVuelo WHERE id LIKE :id%", nativeQuery = true)
	public ReservaVuelo findReservaById(@Param("id") int id);
	
	//Por fecha
	
	@Query(value = "SELECT * FROM reservasVuelo WHERE fecha LIKE :fecha%", nativeQuery = true)
	public Collection<ReservaVuelo> findByFecha(@Param("fecha") LocalDate fecha);
	
	// Por usuario
	
	@Query(value = "SELECT * FROM reservasVuelo WHERE reservasVuelo.user LIKE :user%", nativeQuery = true)
	public Collection<ReservaVuelo> findByUser(@Param("user") User user);
	
	
}
