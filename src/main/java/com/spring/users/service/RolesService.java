package com.spring.users.service;

import java.util.List;
import com.spring.users.model.Roles;

public interface RolesService {

    public List<Roles> getAllRoles();

    public Roles getRolesById(Integer id);

    public void saveOrUpdate(Roles roles);

    public void deleteRoles(Integer id);

}
