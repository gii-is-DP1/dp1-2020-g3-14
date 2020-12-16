package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Comentario;
import org.springframework.samples.petclinic.repository.ComentarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioService {
	
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	public ComentarioService(ComentarioRepository comentarioRepository) {
		this.comentarioRepository = comentarioRepository;
	}
	
	@Transactional(readOnly = true)
	public Comentario findComentarioById(int id) throws DataAccessException {
		return comentarioRepository.findById(id);
	}
	
	@Transactional
	public void saveComentario(Comentario comentario) throws DataAccessException {
		comentarioRepository.save(comentario);                
	}

}
