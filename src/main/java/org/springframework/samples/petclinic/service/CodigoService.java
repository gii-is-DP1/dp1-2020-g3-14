package org.springframework.samples.petclinic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.Codigo;
import org.springframework.samples.petclinic.repository.CodigoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CodigoService {
	
	private CodigoRepository  codigoRepository;
	
	@Autowired
	public CodigoService(CodigoRepository codigoRepository) {
		this.codigoRepository = codigoRepository;
	}
	
	@Transactional(readOnly = true)
	public Codigo findCodigoByPatron(String patron) throws DataAccessException {
		Codigo codigo = codigoRepository.findById(patron).get();
		if(codigo.getValido()==true) {
			codigo.setNvecesusado(codigo.getNvecesusado()-1);
			if(codigo.getNvecesusado()<=0) {
				codigo.setValido(false);
			}
			codigoRepository.save(codigo);
		}
		return codigo;
	}


}
