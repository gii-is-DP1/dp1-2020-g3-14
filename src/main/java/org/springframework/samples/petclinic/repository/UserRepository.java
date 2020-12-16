package org.springframework.samples.petclinic.repository;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.AgenAct;
import org.springframework.samples.petclinic.model.User;


public interface UserRepository extends  CrudRepository<User, String>{
	
	@Query(value="SELECT * FROM Users WHERE username LIKE :username%", nativeQuery = true)
	public User findByUsername(@Param("username") String username);
	
}
