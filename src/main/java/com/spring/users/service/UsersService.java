package com.spring.users.service;

import java.util.List;
import com.spring.users.model.Users;

public interface UsersService {

    public List<Users> getAllUsers();

    public Users getUsersById(Long id);

    public void saveOrUpdate(Users users);

    public void deleteUsers(Long id);

}
