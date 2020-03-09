package com.spring.users.repository;

import org.springframework.data.repository.CrudRepository;
import com.spring.users.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}
