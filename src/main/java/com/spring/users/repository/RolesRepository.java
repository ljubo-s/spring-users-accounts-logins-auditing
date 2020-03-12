package com.spring.users.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.users.model.Roles;

public interface RolesRepository extends CrudRepository<Roles, Integer> {

}
