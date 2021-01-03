package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Hotel;


public interface HotelRepository extends JpaRepository<Hotel, Long> {
	
	@Query("select u from Hotel u where u.nombre like %?1")
	Collection<Hotel> findByNombreLike(String nombre);
	
	@Query("INSERT INTO hoteles(id,direccion,estrellas,nombre,provincia,telefono,precio) VALUES (hotel.id %?1,'hotel.direccion %?1',hotel.estrellas %?1,'hotel.nombre %?1','hotel.provincia %?1','hotel.telefono %?1',hotel.precio %?1")
	Collection<Hotel> saveSolicitud(Hotel hotel);
	
	@Query("select u from Hotel u where u.nombreSolicitud like %?1")
	Collection<Hotel> findByNombreSolicitudLike(String nombreSolicitud);
	
	@Query("select u from Hotel u where u.provincia like %?1")
	Collection<Hotel> findByProvinciaLike(String provincia);
	
	@Query(value = "SELECT DISTINCT provincia FROM Hoteles", nativeQuery = true)
	public Collection<String> findProvincias();
	
	
	
	Hotel findById(int id);
	
}
