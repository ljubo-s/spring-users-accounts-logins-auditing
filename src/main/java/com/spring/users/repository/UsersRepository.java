package com.spring.users.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.users.model.Users;

public interface UsersRepository extends CrudRepository<Users, Integer>{

}
