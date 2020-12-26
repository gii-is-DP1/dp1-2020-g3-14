package org.springframework.samples.petclinic.repository;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario, String>{
	
	Comentario findById(int id) throws DataAccessException;
}
