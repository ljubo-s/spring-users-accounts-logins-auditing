package com.spring.users.service;

import java.util.List;
import com.spring.users.model.Role;

public interface RoleService {

    public List<Role> getAllRole();

    public Role getRoleById(Long id);

    public void saveOrUpdate(Role role);

    public void deleteRole(Long id);

}
