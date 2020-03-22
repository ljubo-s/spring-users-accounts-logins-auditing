package com.spring.users.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.spring.users.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{
	
	@Query("SELECT u FROM Users u WHERE u.username = :username")
	Users getUserByUsername(String username);
	
	@Query("SELECT u FROM Users u WHERE u.username = :username AND u.password = :password")
	Users getUserByUsernameAndPassword(String username, String password);
	
}
