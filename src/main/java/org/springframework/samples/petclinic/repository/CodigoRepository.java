package org.springframework.samples.petclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.Codigo;

public interface CodigoRepository extends JpaRepository<Codigo, String>  {

}
