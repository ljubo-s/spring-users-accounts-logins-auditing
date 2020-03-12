package com.spring.users.service.serviceImpl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.spring.users.model.UsersRoles;
import com.spring.users.repository.UsersRolesRepository;
import com.spring.users.service.UsersRolesService;

@Service
@Transactional
public class UsersRolesServiceImpl implements UsersRolesService {

    @Autowired
    private UsersRolesRepository usersRolesRepository;

    @Override
    public List<UsersRoles> getAllUsersRoles() {
        return (List<UsersRoles>) usersRolesRepository.findAll();
    }

    @Override
    public UsersRoles getUsersRolesById(Integer id) {
        return usersRolesRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(UsersRoles permissionUsers) {
        usersRolesRepository.save(permissionUsers);
    }

    @Override
    public void deleteUsersRoles(Integer id) {
        usersRolesRepository.deleteById(id);
    }

}
