package org.springframework.samples.petclinic.repository;


import java.util.Collection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.ReservaActividad;
import org.springframework.samples.petclinic.model.User;

public interface ReservaActividadRepository extends CrudRepository<ReservaActividad, Integer>{

	
	
	
	//Por id
	
	@Query(value="SELECT * FROM reservasActividad WHERE id LIKE :id%", nativeQuery = true)
	public ReservaActividad findReservaById(@Param("id") int id);
	
	//Por Nombre de la Actividad
	
	@Query(value = "SELECT * FROM reservasActividad WHERE nombre LIKE :nombre%", nativeQuery = true)
	public Collection<ReservaActividad> findByNombre(@Param("nombre") String nombre);
	
	// Por usuario
	
	@Query(value = "SELECT * FROM reservasActividad WHERE reservasActividad.user LIKE :user%", nativeQuery = true)
	public Collection<ReservaActividad> findByUser(@Param("user") User user);
	
	
}
