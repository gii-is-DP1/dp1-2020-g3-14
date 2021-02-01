package org.springframework.samples.petclinic.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.ComentarioActividad;
import org.springframework.samples.petclinic.model.ComentarioHotel;
import org.springframework.samples.petclinic.model.Hotel;
import org.springframework.samples.petclinic.repository.ActividadRepository;
import org.springframework.samples.petclinic.repository.ComentarioActividadRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComentarioActividadService {

	private ComentarioActividadRepository comentarioRepository;
	private ActividadRepository actividadRepository;
	
	@Autowired
	public ComentarioActividadService(ComentarioActividadRepository comentarioRepository,ActividadRepository actividadRepository) {
		this.comentarioRepository = comentarioRepository;
		this.actividadRepository=actividadRepository;
	}
	
	@Transactional(readOnly = true)
	public ComentarioActividad findComentarioById(int id) throws DataAccessException {
		return comentarioRepository.findById(id);
	}
	
	@Transactional
	public void saveComentario(ComentarioActividad comentario) throws DataAccessException {
		comentarioRepository.save(comentario); 
		
	}
	@Transactional
	public void savec(int id, ComentarioActividad comentario) throws DataAccessException{
		Actividad a = actividadRepository.findById(id);
        a.getComentarios().add(comentario);
        List<ComentarioActividad> lscomen = new ArrayList<ComentarioActividad>();
        comentario.setActividad(a);
        lscomen.addAll(a.getComentarios());
        
        Integer media = 0;
        for(int i = 0; i<lscomen.size();i++){
            Integer puntuacion = lscomen.get(i).getPuntuacion();
            media = (media + puntuacion);
         }
         media = media/lscomen.size();
         a.setValoracion(media);
         //actividadRepository.save(a);
         comentarioRepository.save(comentario);
	}
	

	
}
