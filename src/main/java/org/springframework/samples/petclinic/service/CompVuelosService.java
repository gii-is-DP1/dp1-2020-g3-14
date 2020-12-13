package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.CompVuelos;
import org.springframework.samples.petclinic.repository.CompVuelosRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CompVuelosService {
	
	private CompVuelosRepository compVuelosRepository;
	
	@Autowired
	public CompVuelosService(CompVuelosRepository compVuelosRepository) {
		this.compVuelosRepository = compVuelosRepository;
	}
	
	@Transactional(readOnly = true)
	public CompVuelos findCompVuelosById(int id) throws DataAccessException {
		return compVuelosRepository.findById(id);
	}

	@Transactional
	public void saveCompVuelos(CompVuelos compVuelos) throws DataAccessException {
		compVuelosRepository.save(compVuelos);                
	}

	@Transactional(readOnly = true)
	public Collection<CompVuelos> findByNombre(String name) throws DataAccessException {
		return compVuelosRepository.findByNombreLike(name);
	}
	
}
