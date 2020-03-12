package com.spring.users.service;

import java.util.List;
import com.spring.users.model.UsersAud;

public interface UsersAudService {

    public List<UsersAud> getAllUsersAud();

    public UsersAud getUsersAudById(Integer id);

    public void saveOrUpdate(UsersAud users);

    public void deleteUsersAud(Integer id);

}
