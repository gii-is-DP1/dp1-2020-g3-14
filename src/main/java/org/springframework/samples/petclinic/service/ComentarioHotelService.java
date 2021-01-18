package org.springframework.samples.petclinic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.ComentarioHotel;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.repository.ComentarioHotelRepository;
import org.springframework.samples.petclinic.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class ComentarioHotelService {
	
	
	private ComentarioHotelRepository comentarioRepository;
	private HotelRepository hotelRepository;
	
	@Autowired
	public ComentarioHotelService(ComentarioHotelRepository comentarioRepository,HotelRepository hotelRepository) {
		this.comentarioRepository = comentarioRepository;
		this.hotelRepository=hotelRepository;
	}
	
	@Transactional(readOnly = true)
	public ComentarioHotel findComentarioById(int id) throws DataAccessException {
		return comentarioRepository.findById(id);
	}
	
	@Transactional
	public void saveComentario(ComentarioHotel comentario) throws DataAccessException {
		comentarioRepository.save(comentario); 
		
	}
	@Transactional
	public void savec(int id, ComentarioHotel comentario) throws DataAccessException{
		Hotel h = hotelRepository.findById(id);
        h.getComentarios().add(comentario);
        List<ComentarioHotel> lscomen = new ArrayList<ComentarioHotel>();
       
        comentario.setHotel(h);
        lscomen.addAll(h.getComentarios());
        if(lscomen.size() >= 5) {
            Double media = 0.;
            for(int i = 0; i<lscomen.size();i++){
                Integer puntuacion = lscomen.get(i).getPuntuacion();
                media = (media + puntuacion);
            }
            media = media/lscomen.size();
            if(media <= 2) {
            	hotelRepository.findById(id).setValido(false);
            }else {
            	hotelRepository.findById(id).setValido(true);
            }
        }
        comentarioRepository.save(comentario);
	}

}
