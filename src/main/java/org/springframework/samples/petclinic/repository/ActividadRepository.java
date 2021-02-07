package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.Actividad;

public interface ActividadRepository extends JpaRepository<Actividad, Long>  {
	
	@Query("select u from Actividad u where u.nombre like %?1")
	Collection<Actividad> findByNombreLike(String nombre);
	
	@Query("select a from Actividad a")
	public List<Actividad> findAllActividades();

	Actividad findById(int id);

	@Query("select a from Actividad a where a.precio <= ?1")
	Collection<Actividad> findByActividadPrecioLessThanEqual(Integer precio);
}
