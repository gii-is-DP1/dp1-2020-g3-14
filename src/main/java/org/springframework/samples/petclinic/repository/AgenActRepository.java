package org.springframework.samples.petclinic.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.samples.petclinic.model.AgenAct;


public interface AgenActRepository extends JpaRepository<AgenAct, Long>  {
	
	@Query("select u from AgenAct u where u.nombre like %?1")
	Collection<AgenAct> findByNombreLike(String nombre);

	AgenAct findById(int id);
}
