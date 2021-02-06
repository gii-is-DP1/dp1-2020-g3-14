/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.samples.petclinic.model.Actividad;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@DataJpaTest(includeFilters = @ComponentScan.Filter(Service.class))
class AgenActServiceTests {                
        @Autowired
	protected AgenActService agenActService;
    protected ActividadService actividadService;

    @Test
    @Transactional
    public void shouldInsertAgenAct() {
    	Collection<AgenAct> agencias = this.agenActService.findByNombre("Liberty");
    	//No debe existir la agencia con ese nombre en la base de datos
    	int found = agencias.size();
    	//Tamaño 0
    	System.out.println("==========================================================");
    	System.out.println("Agencia Liberty no encontrada. Encontrados = "+found);
    	System.out.println("==========================================================");
    	
    	AgenAct agenAct = new AgenAct();
    	agenAct.setNombre("Liberty");
    	agenAct.setSede("Malaga");
    	agenAct.setTelefono("945323429");
    	
    	Actividad actividad = new Actividad();
    	actividad.setNombre("Escalada");
    	actividad.setDescripcion("Muy buena ruta para realizar con los amigos y muy facil");
    	actividad.setDireccion("Sierra de Grazalema");
    	actividad.setValoracion(4);
    	actividad.setPrecio(2);
    	Set<Actividad> actividades = new HashSet<Actividad>();	
    	actividades.add(actividad);
    	agenAct.setActividades(actividades);
    	
    	this.agenActService.saveAgenAct(agenAct);
    		
    	//Comprobamos que se ha añadido sin problemas
    	agencias = this.agenActService.findByNombre("Liberty");
    	assertThat(agencias.size()).isEqualTo(found+1);
    	System.out.println("Agencia Liberty encontrada. Encontradas= "+actividades.size());
    	System.out.println("==========================================================");
    }
    	
    @Test
    @Transactional
    public void shouldInsertAgenActVacio() {
    	AgenAct agenAct = new AgenAct();
    	agenAct.setNombre("Liberty");
    	agenAct.setSede("");
    	agenAct.setTelefono("");
    		
        assertThat(agenAct.getSede().isEmpty()).isTrue();
    	assertThat(agenAct.getTelefono().isEmpty()).isTrue();
    }

	@Test
	void shouldFindAgenActName() {
		AgenAct agenAct = new AgenAct();
    	agenAct.setNombre("Liberty");
    	agenAct.setSede("Malaga");
    	agenAct.setTelefono("945323429");
    	
    	Actividad actividad = new Actividad();
    	actividad.setNombre("Escalada");
    	actividad.setDescripcion("Muy buena ruta para realizar con los amigos y muy facil");
    	actividad.setDireccion("Sierra de Grazalema");
    	actividad.setValoracion(4);
    	actividad.setPrecio(2);
    	Set<Actividad> actividades = new HashSet<Actividad>();	
    	actividades.add(actividad);
    	agenAct.setActividades(actividades);         
                
    	this.agenActService.saveAgenAct(agenAct);
		
    	//Comprobamos que se ha añadido sin problemas
    	Collection<AgenAct> agencias = this.agenActService.findByNombre("Liberty");
		assertThat(agencias.size()).isEqualTo(1);
	}
	
	@Test
	void shouldNotFindActividadByName() {
		Collection<AgenAct> agencias = this.agenActService.findByNombre("Liberty");
		assertThat(agencias.isEmpty()).isTrue();
	}
}
