package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Comentario;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.repository.ComentarioRepository;
import org.springframework.samples.petclinic.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ComentarioService {
	
	
	private ComentarioRepository comentarioRepository;
	private HotelRepository hotelRepository;
	
	@Autowired
	public ComentarioService(ComentarioRepository comentarioRepository,HotelRepository hotelRepository) {
		this.comentarioRepository = comentarioRepository;
		this.hotelRepository=hotelRepository;
	}
	
	@Transactional(readOnly = true)
	public Comentario findComentarioById(int id) throws DataAccessException {
		return comentarioRepository.findById(id);
	}
	
	@Transactional
	public void saveComentario(Comentario comentario) throws DataAccessException {
		comentarioRepository.save(comentario); 
		
	}
	@Transactional
	public void savec(int id, Comentario comentario) throws DataAccessException{
		Hotel h = hotelRepository.findById(id);
        h.getComentarios().add(comentario);
        comentario.setHotel(h);
        comentarioRepository.save(comentario);
	}

}
