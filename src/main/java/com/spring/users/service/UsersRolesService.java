package com.spring.users.service;

import java.util.List;
import com.spring.users.model.UsersRoles;

public interface UsersRolesService {

    public List<UsersRoles> getAllUsersRoles();

    public UsersRoles getUsersRolesById(Integer id);

    public void saveOrUpdate(UsersRoles usersRoles);

    public void deleteUsersRoles(Integer id);

}
