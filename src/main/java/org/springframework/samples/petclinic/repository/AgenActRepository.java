package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.AgenAct;


public interface AgenActRepository extends Repository<AgenAct, Integer>  {
	
	void save(AgenAct agen) throws DataAccessException;
	
	@Query(value = "SELECT DISTINCT * FROM AgenActs WHERE nombre LIKE :nombre%", nativeQuery = true)
	public Collection<AgenAct> findByNombre(@Param("nombre") String nombre);

	
	@Query(value="SELECT * FROM AgenActs WHERE id LIKE :id%", nativeQuery = true)
	public AgenAct findById(@Param("id") int id);
}
