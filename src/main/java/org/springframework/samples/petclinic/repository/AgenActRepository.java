package org.springframework.samples.petclinic.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.samples.petclinic.model.Owner;


public interface AgenActRepository extends Repository<AgenAct, Integer>  {
		
	
	AgenAct findById(int id) throws DataAccessException;

	
	void save(AgenAct agen) throws DataAccessException;


	Collection<AgenAct> findByNombre(String nombre);


	

}
