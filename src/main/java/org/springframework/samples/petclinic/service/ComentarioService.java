package org.springframework.samples.petclinic.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

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
	@Transactional
	public void savec(int id, Comentario comentario) throws DataAccessException{
		
		Hotel h = hotelRepository.findById(id);
		comentarioRepository.save(comentario);
		List<Comentario> cs =comentarioRepository.findAll();
		for(int i =0;i<cs.size();i++) {
			if(id==cs.get(i).getHotel().getId()) {
				System.out.println("FRAN1");
			}else {
				cs.remove(cs.get(i));
				System.out.println("FRAN MARICON!");
				
			}
		}
		h.setComentarios(cs);
		
		
	}

}
