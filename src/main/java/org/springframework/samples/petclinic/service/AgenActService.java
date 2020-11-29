package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.samples.petclinic.model.Owner;
import org.springframework.samples.petclinic.repository.AgenActRepository;
import org.springframework.samples.petclinic.service.exceptions.DuplicatedAgenActNameException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service
public class AgenActService {
	
	private AgenActRepository agenActRepository;
	
	@Autowired
	public AgenActService(AgenActRepository agenActRepository) {
		this.agenActRepository = agenActRepository;
	}
	
	@Transactional(readOnly = true)
	public AgenAct findAgenActById(int id) throws DataAccessException {
		return agenActRepository.findById(id);
	}

	@Transactional
	public void saveAgenAct(AgenAct agenAct) throws DataAccessException {
		agenActRepository.save(agenAct);                
	}

	@Transactional(readOnly = true)
	public Collection<AgenAct> findByNombre(String name) throws DataAccessException {
		return agenActRepository.findByNombre(name);
	}
	
}
